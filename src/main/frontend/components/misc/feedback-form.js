// Custom element demonstrating two JS→Java communication patterns.
// Java counterpart: FeedbackForm.java
export class FeedbackForm extends HTMLElement {
  connectedCallback() {
    this.innerHTML = `
      <style>
        .btn { margin-right: 10px; }
        .thanks { color: green; margin-top: 10px; }
      </style>
      <div>
        <p>Was this side helpful?</p>
        <button id="yes-btn" class="btn" data-value="yes">👍 Yes</button>
        <button id="no-btw" class="btn" data-value="no">👎 No</button>
        <p class="thanks" hidden>Thank you for your feedback!</p>
      </div>
    `;

    this.querySelectorAll('button').forEach(btn => {
      btn.addEventListener('click', (event) => {
        // Option 1: Fire a CustomEvent — picked up by @DomEvent("button-clicked") in Java
        this.dispatchEvent(new CustomEvent("button-clicked",  {
          detail: { value: event.target.getAttribute("data-value") }
        }));

        // Option 2: Call a @ClientCallable Java method directly via this.$server
        let greetingPromise = this.$server.getGreeting("JavaScript");
        greetingPromise.then(greeting => {
          this.querySelector('.thanks').removeAttribute("hidden");
          alert(greeting + " from Client Side");
        });
      });
    });
  }

  // Called from Java via getElement().callJsFunction("setValue", ...)
  setValue(value) {
    this.querySelector('.thanks').removeAttribute("hidden");
    alert(value + " from Client Side");
  }
}

customElements.define('feedback-form', FeedbackForm);
