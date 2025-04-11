import {Wheel} from 'spin-wheel';
/**
 * This file defines a simple JavaScript-based integration for the SpinWheel component.
 * It uses a global `init` function to create and configure the wheel instance,
 * and exposes a `spin` method directly on the DOM element.
 * This approach avoids defining a full Web Component but allows direct control via Java.
 */

 // Global initializer function to attach a SpinWheel instance to the given DOM element
window.init = (element) => {
  // Define the wheel configuration including the labels for each segment
  const props = {
    items: [{label: 'one'}, { label: 'two' }, { label: 'three' }]
  }

  // Create the wheel instance using the given element and configuration
  const wheel = new Wheel(element, props);

  // Attach a public spin method to the element, accessible from Java using callJsFunction
  element.spin = (rotation) => {
    //create a global function to spin the wheel
    wheel.spinTo(rotation ?? 3000, 3000, null);
  }
}