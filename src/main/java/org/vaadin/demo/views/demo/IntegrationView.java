package org.vaadin.demo.views.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.demo.components.react.RcSlider;
import org.vaadin.demo.components.vanilla.NoUiSlider;
import org.vaadin.demo.components.webcomponents.ShoelaceRange;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

/**
 * Combined demo view showcasing all three slider integration patterns side by side.
 * <p>
 * Each slider is built with a different integration approach:
 * <ul>
 *   <li><b>NoUiSlider</b> — Vanilla JS library wrapped as a custom element</li>
 *   <li><b>RcSlider</b> — React component via {@code ReactAdapterComponent}</li>
 *   <li><b>ShoelaceRange</b> — Third-party Web Component (npm)</li>
 * </ul>
 */
@PageTitle("Integration Demo")
@Route("integration-demo")
@Menu(order = 2, icon = LineAwesomeIconUrl.SLIDERS_H_SOLID)
public class IntegrationView extends VerticalLayout {

    private static final String CURRENT_VALUE_PREFIX = "Current value: ";

    public IntegrationView() {
        // --- Vanilla JS: NoUiSlider ---
        var noUiSliderLabel = new Span(CURRENT_VALUE_PREFIX + 50);
        var noUiSlider = new NoUiSlider();
        noUiSlider.addValueChangeListener(event ->
                noUiSliderLabel.setText(CURRENT_VALUE_PREFIX + event.getValue()));
        noUiSlider.setValue(50);
        noUiSlider.onUpdate();
        noUiSlider.setWidthFull();
        add(new Button("reset", event -> noUiSlider.reset()));

        // --- React: RcSlider ---
        var rcSliderLabel = new Span(CURRENT_VALUE_PREFIX + 50);
        var rcSlider = new RcSlider();
        rcSlider.addValueChangeListener(value ->
                rcSliderLabel.setText(CURRENT_VALUE_PREFIX + value));
        rcSlider.setValue(50);
        add(rcSlider);

        // --- Web Component: ShoelaceRange ---
        var shoelaceLabel = new Span(CURRENT_VALUE_PREFIX + 50);
        var shoelaceRange = new ShoelaceRange();
        shoelaceRange.addSliderChangeValue(event -> {
            shoelaceLabel.setText(CURRENT_VALUE_PREFIX + event.getValue());
        });
        shoelaceRange.setValue(50);
        shoelaceRange.setWidthFull();

        add(
                new H3("Vanilla JS — NoUiSlider"),
                    noUiSlider, noUiSliderLabel,
                new Hr(),
                new H3("React — rc-slider"),
                    rcSlider, rcSliderLabel,
                new Hr(),
                new H3("Web Component — Shoelace Range"),
                    shoelaceRange, shoelaceLabel
        );

        setAlignSelf(Alignment.CENTER, noUiSliderLabel, rcSliderLabel, shoelaceLabel);
        setPadding(true);
        setSpacing(true);
        setSizeFull();
    }
}