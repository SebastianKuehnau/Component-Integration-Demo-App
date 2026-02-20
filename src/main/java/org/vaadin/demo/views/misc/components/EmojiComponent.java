package org.vaadin.demo.views.misc.components;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;

// Wraps a third-party npm Web Component — no custom JS file needed.
// @NpmPackage installs the package, @JsModule loads it, @Tag maps to its HTML tag.
@NpmPackage(value = "emoji-picker-element", version = "^1.26.3")
@JsModule("emoji-picker-element/index.js")
@Tag("emoji-picker")
public class EmojiComponent extends Component implements HasSize {

    public Registration addEmojiClickListener(
            ComponentEventListener<EmojiClickEvent> listener) {
        return addListener(EmojiClickEvent.class, listener);
    }

    @DomEvent("emoji-click")
    public static class EmojiClickEvent extends ComponentEvent<EmojiComponent> {
        private final String unicode;

        public EmojiClickEvent(EmojiComponent source,
                               boolean fromClient,
                               @EventData("event.detail.unicode") String unicode) {
            super(source, fromClient);
            this.unicode = unicode;
        }

        public String getUnicode() {
            return unicode;
        }
    }
}
