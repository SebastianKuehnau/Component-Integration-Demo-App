package org.vaadin.demo.components.vanilla;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

import java.util.function.Consumer;

// Alternative approach: JS connector + executeJs instead of a custom element.
// The connector (nouislider-connector.js) only exposes the library factory to window.
// All setup logic lives in Java's onAttach() via executeJs().
@NpmPackage(value = "nouislider", version = "15.8.1")
@JsModule("./components/vanilla/nouislider-connector.js")
@Tag("nouislider-js-element")
public class NoUiSliderJS extends Component implements HasSize {
    public record Range(double min, double max) {
    }

    private  double value = 0;

    private Range range = new Range(0, 100);

    private Consumer<Double> listener;

    public NoUiSliderJS(Consumer<Double> listener) {
        this.listener = listener;
        setMinWidth("200px");
    }

    // Create the slider in the browser once the element is attached to the DOM
    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        getElement().executeJs("""
                const el = this;
                el._slider = _createSlider(this, {
                    start: $0,
                    connect: [true, false],
                    range: $1
                });
                el._slider.on("update", () => {
                    const value = el._slider.get();
                    // pass to the exposed "server method"
                    el.$server.receiveValue(value);
                });
                """, value, range);
    }

    // JS → Java: called from browser via this.$server.receiveValue()
    @ClientCallable
    void receiveValue(double d) {
        value = d;
        listener.accept(value);
    }

    public void setRange(Range range) {
        assert !isAttached();
        this.range = range;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
        if(isAttached()) {
            getElement().executeJs("this._slider.set($0)", value);
        }
    }
}
