import {ReactAdapterElement, RenderHooks} from 'Frontend/generated/flow/ReactAdapter';
import React, {ReactElement, useState} from 'react';
import Slider from 'rc-slider';
import 'rc-slider/assets/index.css';

class RcSliderElement extends ReactAdapterElement {

    protected render(hooks: RenderHooks): ReactElement | null {
        const [sliderValue, setSliderValue] = hooks.useState<number>('sliderValue');
        const [min] = hooks.useState<number>('min');
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
