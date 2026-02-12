package org.vaadin.demo.views.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.demo.components.custom.MyCustomElement;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Custom Element Demo")
@Route("custom-component")
@Menu(order = 1, icon = LineAwesomeIconUrl.STAR_SOLID)
public class CustomComponentView extends VerticalLayout {

    public CustomComponentView() {
        add(new H1("Simple Custom Component Demo"));

        var customComponent = new MyCustomElement() ;
        customComponent.addTextSubmittedListener(event ->
                Notification.show("Text submitted: " + event.getValue()));
        add(customComponent);


    }
}
