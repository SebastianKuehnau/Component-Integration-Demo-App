package org.vaadin.demo.views.react;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.react.ReactAdapterComponent;
import com.vaadin.flow.function.SerializableConsumer;

/**
 * Server-side Java wrapper for the React component.
 * <p>
 * This class connects to the React component using:
 * - @NpmPackage to install required npm dependencies
 * - @JsModule to import the React adapter (TypeScript side)
 * - @Tag to map this Java class to the corresponding custom element
 * <p>
 * The component extends ReactAdapterComponent to enable server-side interaction
 * and state synchronization between Java and React.
 **/
@NpmPackage(value = "rc-slider", version = "^11.1.8")
@JsModule("./components/react-slider/react-slider.tsx")
@Tag("react-slider")
public class ReactSlider extends ReactAdapterComponent {

    public ReactSlider() {
        super();
        addClassNames("w-full", "h-full");
    }

    /**
     * Gets the current value of the slider from React state.
     */
    public Number getValue() {
        return getState("sliderValue", Number.class);
    }

    /**
     * Sets the value of the slider in the React component.
     */
    public void setValue(Number value) {
        setState("sliderValue", value);
    }

    /**
     * Adds a listener for changes to the slider value in React.
     */
    public void addValueChangeListener(
            SerializableConsumer<Number> listener) {
        addStateChangeListener("sliderValue", Number.class, listener);
    }

}
