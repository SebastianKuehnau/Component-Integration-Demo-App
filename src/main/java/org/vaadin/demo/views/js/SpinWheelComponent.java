package org.vaadin.demo.views.js;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

/**
 * A Java wrapper for the in-project Java Script Component <spin-wheel-component>.
 * <p>
 * This component demonstrates how to use a custom Web Component created
 * within the same project in a Vaadin Flow application.
 * <p>
 * The Web Component is defined in TypeScript (spin-wheel-component.ts) and registered
 * using customElements.define. It can be used in Flow via the @Tag and @JsModule annotations.
 */

@NpmPackage(value = "spin-wheel", version = "^5.0.2")
@JsModule("./components/spin-wheel/spin-wheel-component.js")
@Tag("spin-wheel-component")
public class SpinWheelComponent extends Component implements HasSize {

    /**
     * Creates the SpinWheelComponent and sets its default size.
     * This component wraps the <spin-wheel-component> custom element created in the frontend.
     */
    public SpinWheelComponent() {
        setWidth("100px");
        setHeight("100px");
    }

    /**
     * Calls the 'spin' method defined on the Web Component instance.
     * Triggers the spin animation with a randomized rotation duration.
     */
    public void spin() {
        this.getElement().callJsFunction("spin", (3000 + Math.random() * 3000));
    }

}
