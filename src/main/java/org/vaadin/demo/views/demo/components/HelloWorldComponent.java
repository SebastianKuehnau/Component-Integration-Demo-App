package org.vaadin.demo.views.demo.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;


@JsModule("./components/demo/js-component.js")
@Tag("hello-world")
public class HelloWorldComponent extends Component implements HasSize {
    public void setText(String text) {
        this.getElement().setProperty("innerHTML", text);
    }
}