package org.vaadin.demo.views.misc.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;


@JsModule("./components/misc/hello-world.js")
@Tag("hello-world")
public class HelloWorldComponent extends Component implements HasSize {
    public void setText(String text) {
        this.getElement().setProperty("innerHTML", text);
    }
}