// Vanilla JS custom element: interactive star rating widget.
// Java counterpart: StarRatingComponent.java
class StarRating extends HTMLElement {

    static get observedAttributes() {
        return ['value', 'max'];
    }

    constructor() {
        super();
        this._value = 0;
        this._max = 5;
    }

    connectedCallback() {
        this.style.cssText = 'font-size: 24px; color: gold; cursor: pointer;';
        this._render();

        // Click on a star sets value and fires event to server
        this.addEventListener('click', (e) => {
            const star = e.target.closest('span');
            if (!star) return;

            this._value = parseInt(star.dataset.index) + 1;
            this._render();

            this.dispatchEvent(new CustomEvent('rating-changed', {
                detail: { value: this._value },
                bubbles: true
            }));
        });
    }

    // Property getters/setters — Vaadin calls these via setProperty()
    get value() { return this._value; }
    set value(val) {
        this._value = parseInt(val) || 0;
        if (this.isConnected) this._render();
    }

    get max() { return this._max; }
    set max(val) {
        this._max = parseInt(val) || 5;
        if (this.isConnected) this._render();
    }

    // Called from Java via callJsFunction("reset")
    reset() {
        this._value = 0;
        this._render();
        this.dispatchEvent(new CustomEvent('rating-changed', {
            detail: { value: 0 },
            bubbles: true
        }));
    }

    _render() {
        let html = '';
        for (let i = 0; i < this._max; i++) {
            html += `<span data-index="${i}">${i < this._value ? '★' : '☆'}</span>`;
        }
        this.innerHTML = html;
    }
}

customElements.define('star-rating', StarRating);