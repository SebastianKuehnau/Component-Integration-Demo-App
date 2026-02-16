package org.vaadin.demo.components.webcomponents;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.PropertyDescriptor;
import com.vaadin.flow.component.PropertyDescriptors;

@NpmPackage(value = "@shoelace-style/shoelace", version = "2.20.1")
@JsModule("@shoelace-style/shoelace/dist/components/range/range.js")
@CssImport("@shoelace-style/shoelace/dist/themes/light.css")
@Tag("sl-range")
public class ShoelaceRange
        extends AbstractSinglePropertyField<ShoelaceRange, Integer>
        implements HasSize {

    private static final PropertyDescriptor<Integer, Integer> MIN_PROPERTY =
            PropertyDescriptors.propertyWithDefault("min", 0);
    private static final PropertyDescriptor<Integer, Integer> MAX_PROPERTY =
            PropertyDescriptors.propertyWithDefault("max", 100);
    private static final PropertyDescriptor<Integer, Integer> STEP_PROPERTY =
            PropertyDescriptors.propertyWithDefault("step", 1);

    public ShoelaceRange() {
        super("value", 0, false);
        getElement().setAttribute("tooltip", "none");
    }

    public void setMin(int min) {
        MIN_PROPERTY.set(this, min);
    }

    public int getMin() {
        return MIN_PROPERTY.get(this);
    }

    public void setMax(int max) {
        MAX_PROPERTY.set(this, max);
    }

    public int getMax() {
        return MAX_PROPERTY.get(this);
    }

    public void setStep(int step) {
        STEP_PROPERTY.set(this, step);
    }

    public int getStep() {
        return STEP_PROPERTY.get(this);
    }

    public void addSliderChangeValue(ComponentEventListener<ShoelaceRangeChangeEvent> listener) {
        addListener(ShoelaceRangeChangeEvent.class, listener);
    }

    @DomEvent("sl-input")
    public static class ShoelaceRangeChangeEvent extends ComponentEvent<ShoelaceRange> {

        private final Integer value;

        public ShoelaceRangeChangeEvent(ShoelaceRange source,
                                        boolean fromClient,
                                        @EventData("event.target.value") int value) {
            super(source, fromClient);
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }
}

