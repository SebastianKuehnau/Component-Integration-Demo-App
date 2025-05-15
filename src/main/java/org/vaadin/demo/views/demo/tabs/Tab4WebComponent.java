package org.vaadin.demo.views.demo.tabs;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.vaadin.demo.views.demo.components.EmojiComponent;

public class Tab4WebComponent extends VerticalLayout {

    public Tab4WebComponent() {
        EmojiComponent emojiComponent = new EmojiComponent();
        add(emojiComponent);

    }
}
