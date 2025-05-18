import { ReactAdapterElement, RenderHooks } from 'Frontend/generated/flow/ReactAdapter';
import React from 'react';
import { SpinWheel } from 'react-spin-wheel';
import "react-spin-wheel/dist/index.css"

class ReactSpinWheelElement extends ReactAdapterElement {
  protected render(hooks: RenderHooks): React.ReactElement | null {
    return <SpinWheel
      items={
        ["United States", "Brazil", "India", "China", "Russia", "Australia", "Japan", "Canada", "France", "Germany"]
      }
      onFinishSpin={(item) => {
        alert(item);
      }}
    />;
  }
}

customElements.define('react-spin-wheel', ReactSpinWheelElement);