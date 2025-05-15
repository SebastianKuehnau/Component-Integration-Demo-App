import { Switch } from '@mui/material';
import { ReactAdapterElement, RenderHooks } from 'Frontend/generated/flow/ReactAdapter';
import React, { ReactElement } from 'react';

class ReactSwitchElement extends ReactAdapterElement {
  protected render(hooks: RenderHooks): ReactElement |
    null {
    return <Switch defaultChecked />;
  }
}

customElements.define('react-switch', ReactSwitchElement);
