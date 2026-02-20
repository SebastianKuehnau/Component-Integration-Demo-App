import {ReactAdapterElement, RenderHooks} from 'Frontend/generated/flow/ReactAdapter';
import React, {ReactElement, useState} from 'react';
import Slider from 'rc-slider';
import 'rc-slider/assets/index.css';

// Java counterpart: RcSlider.java
class RcSliderElement extends ReactAdapterElement {

    protected render(hooks: RenderHooks): ReactElement | null {
        // Each hooks.useState() syncs a named state property with Java's setState()/getState().
        // [value, setter] — setter updates both React state AND Java server state.
        const [sliderValue, setSliderValue] = hooks.useState<number>('sliderValue');
        const [min] = hooks.useState<number>('min');  // read-only from React side
        const [max] = hooks.useState<number>('max');
        const [step] = hooks.useState<number>('step');

        return <Slider
            value={sliderValue}
            min={min}
            max={max}
            step={step}
            onChange={value => setSliderValue(Number(value))}
        />;
    }
}

customElements.define('rc-slider', RcSliderElement);
