package org.vaadin.demo.components.react;

import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.react.ReactAdapterComponent;
import com.vaadin.flow.function.SerializableConsumer;

import java.util.ArrayList;
import java.util.List;

// React adapter with full bidirectional state sync via setState()/getState().
// The TSX side (rc-slider.tsx) reads state with hooks.useState() and writes back via setter.
@NpmPackage(value = "rc-slider", version = "11.1.8")
@JsModule("./components/react/rc-slider.tsx")
@Tag("rc-slider")
public class RcSlider extends ReactAdapterComponent implements HasSize {

    private final List<SerializableConsumer<Integer>> valueChangeListeners = new ArrayList<>();

    public RcSlider() {
        setState("min", 0);
        setState("max", 100);
        setState("step", 1);
        setValue(50);
        setWidthFull();
    }

    public int getValue() {
        return getState("sliderValue", Number.class).intValue();
    }

    public void setValue(int value) {
        setState("sliderValue", value);
    }

    public void setMin(int min) {
        setState("min", min);
    }

    public int getMin() {
        return getState("min", Number.class).intValue();
    }

    public void setMax(int max) {
        setState("max", max);
    }

    public int getMax() {
        return getState("max", Number.class).intValue();
    }

    public void setStep(int step) {
        setState("step", step);
    }

    public int getStep() {
        return getState("step", Number.class).intValue();
    }

    // React → Java: notified when React calls setSliderValue() in the TSX
    public void addValueChangeListener(SerializableConsumer<Integer> listener) {
        addStateChangeListener("sliderValue", Number.class,
                number -> listener.accept(number.intValue()));
    }

    private void fireValueChangeListeners(int value) {
        valueChangeListeners.forEach(listener -> listener.accept(value));
    }
}
