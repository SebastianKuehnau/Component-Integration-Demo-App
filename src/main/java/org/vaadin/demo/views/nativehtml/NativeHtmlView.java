package org.vaadin.demo.views.nativehtml;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

/**
  A Vaadin view demonstrating the use of native HTML elements within a Flow UI.

  This example shows how to embed native HTML components such as <input>, <button>
  and <canvas> and enhance them with custom JavaScript logic.

  Vaadin provides many native HTML components like Input, Div, Span, etc., as Java APIs.
  In addition to these, you can use the low-level Element API to add arbitrary HTML elements.

  The canvas element in this example is added using the Element API, and rendered with
  custom drawing logic using the browser's Canvas API.
 */
@PageTitle("Native HTML Element")
@Route("native-html")
@Menu(icon = LineAwesomeIconUrl.INTERNET_EXPLORER)
public class NativeHtmlView extends VerticalLayout {

    /**
     * Creates the UI layout and adds native HTML elements to the view.
     */
    public NativeHtmlView() {

        //Native HTML Components in Vaadin
        Input input = new Input();
        NativeButton button = new NativeButton("Click me", event ->
                Notification.show("Clicked me with input value: " + input.getValue(), 3000, Notification.Position.MIDDLE));
        add(input, button);

        //Native HTML Component created with Element API
        Element canvas = new Element("canvas");
        canvas.getStyle().setBorder("1px solid #ccc");
        canvas.setAttribute("width", "200");
        canvas.setAttribute("height", "100");
        canvas.setAttribute("id", "myCanvas");

        getElement().appendChild(canvas);
    }

    /**
     * Executes custom JavaScript on attach to draw and handle interactions on the canvas element.
     * This demonstrates how to mix native HTML drawing APIs with Vaadin-managed components.
     */
    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        attachEvent.getUI().getElement().executeJs("""
              const canvas = document.getElementById("myCanvas");
              const ctx = canvas.getContext("2d");
              const button = { x: 50, y: 30, width: 100, height: 40 };
        
              function drawButton() {
                ctx.fillStyle = "#007bff";
                ctx.fillRect(button.x, button.y, button.width, button.height);
                ctx.fillStyle = "#fff";
                ctx.font = "16px sans-serif";
                ctx.fillText("Click me", button.x + 15, button.y + 25);
              }
        
              canvas.addEventListener("click", function (e) {
                const rect = canvas.getBoundingClientRect();
                const x = e.clientX - rect.left;
                const y = e.clientY - rect.top;
        
                if (
                  x >= button.x &&
                  x <= button.x + button.width &&
                  y >= button.y &&
                  y <= button.y + button.height
                ) {
                  alert("Button clicked!");
                }
              });
        
              drawButton();

        """);
    }
}
