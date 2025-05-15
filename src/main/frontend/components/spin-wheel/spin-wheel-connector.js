import {Wheel} from 'spin-wheel';
/**
 * Simple JavaScript-based integration for the SpinWheel component.
 * It uses a global `init` function to create and configure the wheel instance,
 * and exposes a `spin` method directly on the DOM element.
 * This approach avoids defining a full Web Component but allows direct control via Java.
 */

 // Global initializer function to attach a SpinWheel instance to the given DOM element
window.initWheel = (element) => {
  // Configure Wheel properties
  const props = {
    items: [{label: 'one'}, { label: 'two' }, { label: 'three' }]
  }

  // Create wheel instance using the given element and configuration
  element.wheel = new Wheel(element, props);

  // Attach a public spin method to the element, accessible from Java using callJsFunction
  element.spin = (rotation) => {
    element.wheel.spinTo(rotation ?? 3000, 3000, null);
  }
}