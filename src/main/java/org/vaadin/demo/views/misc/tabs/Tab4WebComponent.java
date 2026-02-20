package org.vaadin.demo.views.misc.tabs;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.vaadin.demo.views.misc.components.EmojiComponent;

// Pattern: Third-party npm Web Component (emoji-picker-element) with @DomEvent.
// No custom JS needed — the npm package already provides a <emoji-picker> element.
public class Tab4WebComponent extends VerticalLayout {

    public Tab4WebComponent() {
        EmojiComponent emojiComponent = new EmojiComponent();
        emojiComponent.addEmojiClickListener(event ->
                Notification.show("Your current selection is: " + event.getUnicode()));
        add(emojiComponent);
    }
}
