import noUiSlider from 'nouislider';
import 'nouislider/dist/nouislider.css';

class NoUiSliderElement extends HTMLElement {
    constructor() {
        super();
        this._min = 0;
        this._max = 100;
        this._step = 1;
        this._value = 0;
        this._slider = null;
    }

    connectedCallback() {
        const container = document.createElement('div');
        this.appendChild(container);

        this._slider = noUiSlider.create(container, {
            //Configuration
            start: [this._value],
            step: this._step,
            connect: [true, false],
            range: {
                min: this._min,
                max: this._max
            }
        });

        const handleUpdate = (values) => {
            this._value = parseInt(values[0]);
            this.dispatchEvent(new CustomEvent('value-changed', {
                detail: {value: this._value}
            }));
        };


        // 'slide' fires during user drag, 'set' fires on release and click-to-position
        this._slider.on('slide', handleUpdate);
        this._slider.on('set', handleUpdate);
    }

    get value() {
        return this._value;
    }

    set value(val) {
        const intVal = parseInt(val) || 0;

        this._value = intVal;
        if (this._slider) {
            this._slider.set([intVal]);
        }
    }

    get min() {
        return this._min;
    }

    set min(val) {
        this._min = parseInt(val) || 0;
    }

    get max() {
        return this._max;
    }

    set max(val) {
        this._max = parseInt(val) || 100;
    }

    get step() {
        return this._step;
    }

    set step(val) {
        this._step = parseInt(val) || 1;
    }

    disconnectedCallback() {
        if (this._slider) {
            this._slider.destroy();
            this._slider = null;
        }
    }
    //Getter and Setter
}
customElements.define('nouislider-element', NoUiSliderElement);
