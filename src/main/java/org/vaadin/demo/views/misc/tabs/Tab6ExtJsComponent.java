package org.vaadin.demo.views.misc.tabs;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.vaadin.demo.views.misc.components.FeedbackForm;

// Pattern: Bidirectional Java↔JS communication using both @DomEvent and callJsFunction.
// See FeedbackForm.java (Java wrapper) and feedback-form.js (custom element).
public class Tab6ExtJsComponent extends VerticalLayout {

    public Tab6ExtJsComponent() {
        FeedbackForm feedbackForm = new FeedbackForm();

        // JS→Java via @DomEvent, then Java→JS via callJsFunction
        feedbackForm.addFeedbackClickListener(event -> {
            Notification.show("Hello " + event.getValue().toUpperCase() + " from Server Side");
            feedbackForm.getElement().callJsFunction("setValue", "Hello " + event.getValue().toLowerCase());
        });

        add(feedbackForm);
    }
}
