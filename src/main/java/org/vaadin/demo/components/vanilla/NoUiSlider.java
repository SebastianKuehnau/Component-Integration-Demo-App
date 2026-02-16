package org.vaadin.demo.components.vanilla;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;

@NpmPackage(value = "nouislider", version = "15.8.1")
@JsModule("./components/vanilla/nouislider-element.js")
@Tag("nouislider-element")
public class NoUiSlider extends Component implements HasSize {

    public void setMin(int min) {
        getElement().setProperty("min", min);
    }

    public int getMin() {
        return getElement().getProperty("min", 0);
    }

    public void setMax(int max) {
        getElement().setProperty("max", max);
    }

    public int getMax() {
        return getElement().getProperty("max", 100);
    }

    public void setStep(int step) {
        getElement().setProperty("step", step);
    }

    public int getStep() {
        return getElement().getProperty("step", 1);
    }

    public void setValue(Integer value) {
        getElement().setProperty("value", value);
    }

    public int getValue() {
        return getElement().getProperty("value", 0);
    }

    public Registration addValueChangeListener(ComponentEventListener<SliderChangeEvent> listener) {
        return addListener(SliderChangeEvent.class, listener);
    }

    @DomEvent("value-changed")
    public static class SliderChangeEvent extends ComponentEvent<NoUiSlider> {
        private final Integer value;

        public SliderChangeEvent(NoUiSlider source,
                                 boolean fromClient,
                                 @EventData("event.detail.value") Integer value) {
            super(source, fromClient);
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }
}