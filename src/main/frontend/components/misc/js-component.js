class HelloWorld extends HTMLElement {
  connectedCallback() {
    this.innerHTML = '<p>Hello, Component!</p>';
  }
}

customElements.define('hello-world', HelloWorld);
