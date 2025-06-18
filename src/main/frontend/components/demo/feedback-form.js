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
        //Option One
        this.dispatchEvent(new CustomEvent("button-clicked",  {
          detail: { value: event.target.getAttribute("data-value") }
        }));

        //Option Two
        // let greetingPromise = this.$server.getGreeting("JavaScript");
        // greetingPromise.then(greeting => {
        //   this.querySelector('.thanks').removeAttribute("hidden");
        //   alert(greeting + " from Client Side");
        // });
      });
    });
  }

  setValue(value) {
    this.querySelector('.thanks').removeAttribute("hidden");
    alert(value + " from Client Side");
  }
}

customElements.define('feedback-form', FeedbackForm);
