package org.vaadin.demo.views.misc.tabs;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.vaadin.demo.views.misc.components.EmojiComponent;

public class Tab4WebComponent extends VerticalLayout {

    public Tab4WebComponent() {
        EmojiComponent emojiComponent = new EmojiComponent();
        add(emojiComponent);

    }
}
