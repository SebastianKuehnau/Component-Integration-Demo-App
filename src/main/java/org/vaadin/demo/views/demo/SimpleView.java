package org.vaadin.demo.views.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

import java.util.List;

@RouteAlias("")
@Route("simple-demo")
@Menu(order = 0, icon = LineAwesomeIconUrl.VAADIN)
// Compares three ways to build UI: Vaadin components, native HTML, and addons.
public class SimpleView extends VerticalLayout {

    public SimpleView() {

        /*** Vaadin Components ***/
        add(new H1("Vaadin Components"));
        var vaadinComponentLayout = new HorizontalLayout(
                new TextField("", "your name"), new Button("Click me"), new ComboBox<>("", List.of("One", "Two", "Three")));
        add(vaadinComponentLayout);
        add(new Anchor("https://vaadin.com/docs/latest/components", createLinkButton("Vaadin Components Docs")), new Hr());

        /*** Native HTML Components ***/
        add(new H1("Native HTML Components"));
        var nativeHtmlLayout = new HorizontalLayout(createSimpleInput(), new NativeButton("click me"));
        nativeHtmlLayout.getElement().appendChild(createSimpleSelect());
        add(nativeHtmlLayout);
        add(new Anchor("https://vaadin.com/docs/latest/components/html-elements", createLinkButton("Standard HTML Elements Docs")), new Hr());

        /*** Vaadin Addon Directory ***/
        add(new H1("Vaadin Addon Directory"));
        add(new Anchor("https://vaadin.com/directory", createLinkButton("visit the Vaadin Addon Directory")), new Hr());
    }

    // Build a native <select> using the low-level Element API with event listener
    private Element createSimpleSelect() {
        var select = new Element("select");

        select.appendChild(new Element("option").setAttribute("value", "1").setText("One"));
        select.appendChild(new Element("option").setAttribute("value", "2").setText("Two"));
        select.appendChild(new Element("option").setAttribute("value", "3").setText("Three"));

        select.addEventListener("input", event -> {
            var value = event.getEventData().get("element.value").asString();
            Notification.show("Selected Value: " + value);
        }).addEventData("element.value");

        return select;
    }

    private Input createSimpleInput() {
        var input = new Input();
        input.setPlaceholder("your name");

        return input;
    }

    private Button createLinkButton(String buttonLabel) {
        var linkButton = new Button(buttonLabel);
        linkButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);

        return linkButton;
    }
}
