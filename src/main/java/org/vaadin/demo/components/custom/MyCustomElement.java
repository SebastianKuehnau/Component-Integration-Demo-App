package org.vaadin.demo.components.custom;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.shared.Registration;

@JsModule("./components/custom/my-custom-element.js")
@Tag("my-custom-element")
public class MyCustomElement extends Component implements HasSize {

    // --- Java → JS: set the text field value from the server ---
    public void setText(String text) {
        getElement().callJsFunction("setText", text);
    }

    // --- JS → Java (DOM Event): fired when the user clicks the button ---
    public Registration addTextSubmittedListener(ComponentEventListener<TextSubmittedEvent> listener) {
        return addListener(TextSubmittedEvent.class, listener);
    }

    // --- Event classes ---
    @DomEvent("text-submitted")
    public static class TextSubmittedEvent extends ComponentEvent<MyCustomElement> {
        private final String value;

        public TextSubmittedEvent(MyCustomElement source,
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