package org.vaadin.demo.views.misc.tabs;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.vaadin.demo.views.misc.components.SwitchComponent;

// Pattern: React component via ReactAdapterComponent (minimal example).
// See SwitchComponent.java (Java wrapper) and react-switch.tsx (React side).
public class Tab3ReactComponent extends VerticalLayout {

    public Tab3ReactComponent() {
        add(new SwitchComponent());
    }
}
