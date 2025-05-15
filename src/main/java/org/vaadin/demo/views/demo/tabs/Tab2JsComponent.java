package org.vaadin.demo.views.demo.tabs;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.vaadin.demo.views.demo.components.HelloWorldComponent;


public class Tab2JsComponent extends VerticalLayout {

    public Tab2JsComponent() {
        HelloWorldComponent helloWorldComponent = new HelloWorldComponent();
        helloWorldComponent.setSizeFull();
        add(helloWorldComponent);
        setSizeFull();

        var button = new Button("Click me", event -> {
                helloWorldComponent.setText("<p>Hello World from JS Component</p>");
        });
        add(button);
    }
}
