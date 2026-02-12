package org.vaadin.demo.views.misc.components;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

@DomEvent("button-clicked")
public class MyClickEvent extends ComponentEvent<FeedbackForm> {
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
