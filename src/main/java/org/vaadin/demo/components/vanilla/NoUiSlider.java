package org.vaadin.demo.components.vanilla;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.dom.DebouncePhase;
import com.vaadin.flow.shared.Registration;

@NpmPackage(value = "nouislider", version = "15.8.1")
@JsModule("./components/vanilla/nouislider-element.js")
@Tag("nouislider-element")
public class NoUiSlider extends Component implements HasSize {

    public NoUiSlider() {
        //syncs the "value" property from browser to server on each "value-change" event
        getElement().addPropertyChangeListener("value", "value-changed",
                event -> {});
    }

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


    public Integer getValue() {
        return getElement().getProperty("value", 0);
    }

    public void setValue(Integer value) {
        getElement().setProperty("value", value);
    }

    public Registration addValueChangeListener(ComponentEventListener<SliderValueChangeEvent> listener) {
        return addListener(SliderValueChangeEvent.class, listener);
    }

    @DomEvent(value = "value-changed", debounce = @DebounceSettings
            (timeout = 250, phases = DebouncePhase.INTERMEDIATE))
    public static class SliderValueChangeEvent extends ComponentEvent<NoUiSlider> {
        private final Integer value;

        public SliderValueChangeEvent(NoUiSlider source,
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