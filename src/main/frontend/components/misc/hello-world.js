class HelloWorld extends HTMLElement {
    constructor() {
        super();
    }

    connectedCallback() {
        this.innerHTML = 'Hello World';
    }
}
customElements.define('hello-world', HelloWorld);