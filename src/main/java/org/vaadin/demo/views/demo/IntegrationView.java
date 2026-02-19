package org.vaadin.demo.views.demo;

import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.tabs.TabSheetVariant;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.demo.components.react.RcSlider;
import org.vaadin.demo.components.vanilla.NoUiSlider;
import org.vaadin.demo.components.vanilla.NoUiSliderJS;
import org.vaadin.demo.components.webcomponents.ShoelaceRange;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

/**
 * Combined demo view showcasing four slider integration patterns side by side.
 * <p>
 * Each slider is built with a different integration approach:
 * <ul>
 *   <li><b>NoUiSlider</b> — Vanilla JS library wrapped as a custom element</li>
 *   <li><b>NoUiSliderJS</b> — Vanilla JS library via JS connector + executeJs</li>
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
        // --- Vanilla JS: NoUiSlider (Custom Element) ---
        var noUiSliderLabel = new Span(CURRENT_VALUE_PREFIX + 50);
        var noUiSlider = new NoUiSlider();
        noUiSlider.addValueChangeListener(event ->
            noUiSliderLabel.setText(CURRENT_VALUE_PREFIX + event.getValue()));
        noUiSlider.setValue(50);
        noUiSlider.setWidthFull();

        var noUiSliderTab = new VerticalLayout(noUiSlider, noUiSliderLabel);
        noUiSliderTab.setAlignSelf(Alignment.CENTER, noUiSliderLabel);
        noUiSliderTab.addClassNames(LumoUtility.Padding.Horizontal.NONE,
                LumoUtility.Padding.Top.LARGE);
        noUiSliderTab.setPadding(false);

        // --- Vanilla JS: NoUiSlider (JS Connector) ---
        var noUiSliderJSLabel = new Span(CURRENT_VALUE_PREFIX + 50);
        var nouiSliderJS = new NoUiSliderJS(value ->
                noUiSliderJSLabel.setText(CURRENT_VALUE_PREFIX + value.intValue()));
        nouiSliderJS.setValue(50);
        nouiSliderJS.setWidthFull();

        var noUiSliderJSTab = new VerticalLayout(nouiSliderJS, noUiSliderJSLabel);
        noUiSliderJSTab.addClassName(LumoUtility.Padding.Horizontal.NONE);
        noUiSliderJSTab.setAlignSelf(Alignment.CENTER, noUiSliderJSLabel);
        noUiSliderJSTab.setPadding(false);

        // --- TabSheet for the two Vanilla JS variants ---
        var tabSheet = new TabSheet();
        tabSheet.add("Custom Element", noUiSliderTab);
        tabSheet.add("JS Connector", noUiSliderJSTab);
        tabSheet.addThemeVariants(TabSheetVariant.LUMO_NO_PADDING);
        tabSheet.setWidthFull();

        // --- React: RcSlider ---
        var rcSliderLabel = new Span(CURRENT_VALUE_PREFIX + 50);
        var rcSlider = new RcSlider();
        rcSlider.addValueChangeListener(value ->
                rcSliderLabel.setText(CURRENT_VALUE_PREFIX + value));
        rcSlider.setValue(50);

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
                    tabSheet,
                new Hr(),
                new H3("React — rc-slider"),
                    rcSlider, rcSliderLabel,
                new Hr(),
                new H3("Web Component — Shoelace Range"),
                    shoelaceRange, shoelaceLabel
        );

        setAlignSelf(Alignment.CENTER, rcSliderLabel, shoelaceLabel);
        setPadding(true);
        setSpacing(true);
        setSizeFull();
    }
}
