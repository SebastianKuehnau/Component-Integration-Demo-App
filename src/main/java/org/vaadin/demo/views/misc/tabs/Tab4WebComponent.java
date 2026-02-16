package org.vaadin.demo.views.misc.tabs;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.vaadin.demo.views.misc.components.EmojiComponent;

public class Tab4WebComponent extends VerticalLayout {

    public Tab4WebComponent() {
        EmojiComponent emojiComponent = new EmojiComponent();
        emojiComponent.addEmojiClickListener(event ->
                Notification.show("Your current selection is: " + event.getUnicode()));
        add(emojiComponent);
    }
}
