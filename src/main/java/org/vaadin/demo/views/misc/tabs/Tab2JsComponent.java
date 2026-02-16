package org.vaadin.demo.views.misc.tabs;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.vaadin.demo.views.misc.components.HelloWorldComponent;
import org.vaadin.demo.views.misc.components.StarRatingComponent;


public class Tab2JsComponent extends VerticalLayout {

    public Tab2JsComponent() {

        add(new H3("Star Rating"));
        var starRating = new StarRatingComponent();
        starRating.setMaxStars(5);
        starRating.addRatingChangedListener(event ->
                Notification.show("Rating: " + event.getValue() + " stars"));
        add(starRating);

        setSizeFull();
    }
}
