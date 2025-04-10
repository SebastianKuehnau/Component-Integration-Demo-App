import { ReactAdapterElement, RenderHooks } from 'Frontend/generated/flow/ReactAdapter';
import React, { ReactElement } from 'react';
import Slider from 'rc-slider';
import 'rc-slider/assets/index.css';

// Flow provides the ReactAdapterElement class to create Web Components rendered with React.
class ReactSliderElement extends ReactAdapterElement {

  // Define the render callback using React JSX.
  // Manage state and events with the hooks API.
  protected render(hooks: RenderHooks): ReactElement | null {
    // Sync slider value state with the server
    const [sliderValue, setSliderValue] = hooks.useState<number>('sliderValue');

    // Render the third-party React component with the adapter state.
    return <Slider
              value={sliderValue}
              onChange={value => setSliderValue(Number(value))}
            />;
  }
}

// Register the Web Component with its DOM tag.
customElements.define('react-slider', ReactSliderElement);