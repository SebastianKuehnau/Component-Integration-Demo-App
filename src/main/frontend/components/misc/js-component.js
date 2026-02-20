// Minimal custom element — registered as <hello-world>, loaded via @JsModule in Java.
class HelloWorld extends HTMLElement {
  connectedCallback() {
    this.innerHTML = '<p>Hello, Component!</p>';
  }
}

customElements.define('hello-world', HelloWorld);
