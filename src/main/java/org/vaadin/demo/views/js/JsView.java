package org.vaadin.demo.views.js;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.demo.views.js.components.SpinWheelComponent;
import org.vaadin.demo.views.js.components.SpinWheelIifeWrapper;
import org.vaadin.demo.views.js.components.SpinWheelWrapper;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

/**
 * A view demonstrating two different approaches to integrating JavaScript components in Vaadin.
 * <p>
 * This view includes both:
 * - A SpinWheelComponent: based on a custom Web Component
 * - A SpinWheelWrapper: based on JavaScript initialization via the Element API
 * <p>
 * It shows how to trigger methods like spin() from Java using callJsFunction(),
 * and how to handle multiple integration patterns side by side.
 */
@PageTitle("JavaScript based Component")
@Route("js")
@Menu(icon = LineAwesomeIconUrl.JS)
public class JsView extends VerticalLayout {

    public JsView() {

        var componentLayout1 = new HorizontalLayout();
        for (int i = 0; i < 3; i++) {
            var spinWheel = new SpinWheelWrapper();
            var spinButton = new Button("Spin", event -> spinWheel.spin());
            componentLayout1.add(new VerticalLayout(spinWheel, spinButton));
        }
        add(new VerticalLayout(new Span("Global JS"), componentLayout1));

        var componentLayout2 = new HorizontalLayout();
        for (int i = 0; i < 3; i++) {
            var spinWheel = new SpinWheelIifeWrapper();
            var spinButton = new Button("Spin", event -> spinWheel.spin());
            componentLayout2.add(new VerticalLayout(spinWheel, spinButton));
        }
        add(new VerticalLayout(new Span("IIFE JS"), componentLayout2));

        var componentLayout3 = new HorizontalLayout();
        for (int i = 0; i < 3; i++) {
            var spinWheelComponent = new SpinWheelComponent();
            var button = new Button("Spin", event -> spinWheelComponent.spin());
            componentLayout3.add(new VerticalLayout(spinWheelComponent, button));
        }
        add(new VerticalLayout(new Span("WebComponent JS"), componentLayout3));
    }
}
