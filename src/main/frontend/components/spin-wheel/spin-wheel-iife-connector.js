import {Wheel} from 'spin-wheel';
/**
 * SpinWheel integration using an IIFE (Immediately Invoked Function Expression).
 * Encapsulates all internal state (e.g. props, wheel instances) and avoids wasting the global scope.
 */

// Start of IIFE: isolates scope to avoid global variable leaks
(() => {
  // Default wheel properties (kept private inside the IIFE)
  const defaultProps = {
    items: [{label: 'one'}, { label: 'two' }, { label: 'three' }]
  }

  // Stores per-element wheel instances to support multiple independent wheels
  const instances = new WeakMap();

  // Global init method to initialize a SpinWheel instance on a given element
  window.init = (element) => {
    // 2. Create the wheel in the container and initialise it with the props:
    const wheel = new Wheel(element, defaultProps);
    instances.set(element, wheel);

    // Expose a public 'spin' method on the DOM element to control the wheel from Java
    element.spin = (rotation) => {
      const wheelInstance = instances.get(element);
      wheelInstance?.spinTo(rotation ?? 3000, 3000, null);
    }
  }
})();