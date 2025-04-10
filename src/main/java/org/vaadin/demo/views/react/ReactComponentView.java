package org.vaadin.demo.views.react;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

/**
 * View that demonstrates integration of a React component in a Vaadin Flow UI.
 * <p>
 * React is a popular JavaScript-based frontend UI library with many components.
 * This view shows how to use a React component in Java using Vaadin's React integration API.
 * <p>
 * The integration works through an intermediate Web Component adapter:
 * - A server-side Java class (`ReactSlider`) extends `Component` and links to the custom element
 * - A client-side TypeScript file (`react-slider.tsx`) defines the React component logic
 * <p>
 * In this view, we use the ReactSlider component as a regular Vaadin component,
 * register a value change listener, and show a notification with the updated value.
 */
@PageTitle("React Component in Flow")
@Menu(icon = LineAwesomeIconUrl.REACT)
@Route("react-component")
public class ReactComponentView extends VerticalLayout {

    public ReactComponentView() {
        ReactSlider reactSlider = new ReactSlider();

        var notification = new Notification();
        notification.addThemeVariants(NotificationVariant.LUMO_PRIMARY);
        notification.setPosition(Notification.Position.BOTTOM_CENTER);
        notification.setDuration(5000);

        reactSlider.addValueChangeListener(number -> {
            notification.setText(String.valueOf(number));
            notification.open();
        });

        add(reactSlider);
    }
}