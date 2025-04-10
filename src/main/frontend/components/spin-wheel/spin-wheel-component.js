/**
 * This file defines a custom Web Component <spin-wheel-component>
 * that wraps the SpinWheel functionality using the 'spin-wheel' library.
 * The component can be used declaratively and exposes a public 'spin' method.
 */

 // Define the custom element class for the spin wheel
class SpinWheelComponent extends HTMLElement {

  // Default properties used to initialize the wheel
  _props = {
    items: [ { label: 'one' }, { label: 'two' }, { label: 'three' } ]
  };

  // Lifecycle callback called when the element is added to the DOM
  connectedCallback() {
    if (!this._props) {
      this.textContent = "No labels defined. Please review your code";
    } else {
      this.initWheel();
    }
  }

  // Public method to spin the wheel to a target rotation
  spin(rotation) {
    this.wheel.spinTo(rotation ?? 3000, 3000, null);
  }

  // Initializes or updates the wheel instance with the current properties
  initWheel() {
    if (this.wheel) {
      this.wheel.init(this._props);
    } else {
      this.wheel = new Wheel(this, this._props);
    }
  }
}

// Register the custom element so it can be used as <spin-wheel-component>
customElements.define('spin-wheel-component', SpinWheelComponent);