package org.vaadin.demo.views.misc.components;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.shared.Registration;

// Demonstrates two JS→Java communication options in one component.
@JsModule("./components/misc/feedback-form.js")
@Tag("feedback-form")
public class FeedbackForm extends Component implements HasSize {

    // Option 1: JS fires a @DomEvent, Java listens via addListener()
    public Registration addFeedbackClickListener(ComponentEventListener<MyClickEvent> listener) {
        return addListener(MyClickEvent.class, listener);
    }

    // Option 2: JS calls this.$server.getGreeting() — a @ClientCallable RPC method
    @ClientCallable
    public String getGreeting(String name) {
        Notification.show("Hello " + name.toUpperCase() + " from Server Side");
        return "Hello " + name.toLowerCase();
    }

    @DomEvent("button-clicked")
    public static class MyClickEvent extends ComponentEvent<FeedbackForm> {
        private final String value;

        public MyClickEvent(FeedbackForm source,
                            boolean fromClient,
                            @EventData("event.detail.value") String value) {
            super(source, fromClient);
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
