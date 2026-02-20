import { ReactAdapterElement, RenderHooks } from 'Frontend/generated/flow/ReactAdapter';
import React from 'react';
import { SpinWheel } from 'react-spin-wheel';
import "react-spin-wheel/dist/index.css"

// Java counterpart: SpinWheelComponent.java
class ReactSpinWheelElement extends ReactAdapterElement {
  protected render(hooks: RenderHooks): React.ReactElement | null {

    // hooks.useState syncs state bidirectionally with Java's setState()/getState()
    const [items, setItems] = hooks.useState<string[]>('items');
    // hooks.useCustomEvent fires a DOM event that Java can listen to
    const onFinishSpinEvent = hooks.useCustomEvent<string>("onFinishSpin");

    return <SpinWheel
      items={items}
      onFinishSpin={result =>
        onFinishSpinEvent(result as string)} />;
    }
  }

customElements.define('react-spin-wheel', ReactSpinWheelElement);