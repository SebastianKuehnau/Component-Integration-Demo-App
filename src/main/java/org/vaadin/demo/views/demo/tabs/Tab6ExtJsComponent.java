package org.vaadin.demo.views.demo.tabs;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.vaadin.demo.views.demo.components.FeedbackForm;

public class Tab6ExtJsComponent extends VerticalLayout {

    public Tab6ExtJsComponent() {
        FeedbackForm feedbackForm = new FeedbackForm();

        //Option One
        feedbackForm.addFeedbackClickListener(event -> {
            Notification.show("Hello " + event.getValue().toUpperCase() + " from Server Side");
            feedbackForm.getElement().callJsFunction("setValue", "Hello " + event.getValue().toLowerCase());
        });

        add(feedbackForm);
    }
}
