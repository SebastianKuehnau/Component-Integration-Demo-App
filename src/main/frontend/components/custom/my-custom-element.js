// Simple custom element — no Shadow DOM, so host page styles apply directly.
class MyCustomElement extends HTMLElement {

    connectedCallback() {
        this.innerHTML =
            '<div style="display: flex; gap: 8px; align-items: center;">' +
                '<input type="text" placeholder="Enter text...">' +
                '<button>OK</button>' +
            '</div>';

        this._input = this.querySelector('input');
        this._button = this.querySelector('button');

        // JS → Java: Custom DOM Event (picked up by @DomEvent on the server)
        this._button.addEventListener('click', () => {
            this.dispatchEvent(new CustomEvent('text-submitted', {
                detail: { value: this._input.value }
            }));
        });
    }

    // Called from Java via getElement().callJsFunction("setText", value)
    setText(value) {
        this._input.value = value;
    }
}
customElements.define('my-custom-element', MyCustomElement);