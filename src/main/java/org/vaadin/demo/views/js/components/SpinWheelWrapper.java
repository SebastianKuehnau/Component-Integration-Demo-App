package org.vaadin.demo.views.js.components;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Div;

/**
 * A Java wrapper that connects to a JavaScript-initialized element using the Element API.
 * <p>
 * This class demonstrates an alternative to Web Component-based integration, where
 * the custom behavior is initialized from JavaScript (spin-wheel-connector.js)
 * and attached to a standard HTML element.
 * <p>
 * The JavaScript creates and manages the wheel instance and exposes API methods
 * like spin() on the element instance.
 */

@NpmPackage(value = "spin-wheel", version = "^5.0.2")
@JsModule("./components/spin-wheel/spin-wheel-connector.js")
public class SpinWheelWrapper extends Div implements HasSize {

    /**
     * Constructs the SpinWheelWrapper component and sets its default size.
     */
    public SpinWheelWrapper() {
        setWidth("100px");
        setHeight("100px");
    }

    /**
     * Called when the component is attached to the UI.
     * Executes a JavaScript function to initialize the wheel behavior for this element.
     */
    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        // Initialize the wheel by calling the global JavaScript function 'init'.
        // This sets up the spin behavior and binds methods like 'spin' to this element.
        getElement().executeJs("window.initWheel(this)");
    }

    /**
     * Triggers the spin behavior on the underlying wheel element by calling its JS function.
     */
    public void spin() {
        // Call the 'spin' function that was attached to this element in the JavaScript init logic.
        // This triggers the actual spinning animation on this specific wheel instance.
        getElement().callJsFunction("spin", (Math.random() * 1000 + 3000));
    }
}
