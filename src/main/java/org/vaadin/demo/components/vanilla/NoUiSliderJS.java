package org.vaadin.demo.components.vanilla;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

import java.util.function.Consumer;

@NpmPackage(value = "nouislider", version = "15.8.1")
// This tiny JS exposes methods from JS module to the element/host page
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
