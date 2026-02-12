import { ReactAdapterElement, RenderHooks } from 'Frontend/generated/flow/ReactAdapter';
import React from 'react';
import { SpinWheel } from 'react-spin-wheel';
import "react-spin-wheel/dist/index.css"

class ReactSpinWheelElement extends ReactAdapterElement {
  protected render(hooks: RenderHooks): React.ReactElement | null {

    const [items, setItems] = hooks.useState<string[]>('items');
    const onFinishSpinEvent = hooks.useCustomEvent<string>("onFinishSpin");

    return <SpinWheel
      items={items}
      onFinishSpin={result =>
        onFinishSpinEvent(result as string)} />;
    }
  }

customElements.define('react-spin-wheel', ReactSpinWheelElement);