package org.vaadin.demo.views.demo.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@NpmPackage(value = "emoji-picker-element", version = "^1.26.3")
@JsModule("emoji-picker-element/index.js")
@Tag("emoji-picker")
public class EmojiComponent extends Component implements HasSize {

    public EmojiComponent() {

    }
}
