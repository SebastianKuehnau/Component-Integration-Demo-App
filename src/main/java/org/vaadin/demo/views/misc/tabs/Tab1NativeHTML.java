package org.vaadin.demo.views.misc.tabs;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Element;

// Pattern: Native HTML via Vaadin's Element API — no JS file needed.
// Creates a <canvas> and draws on it using inline executeJs().
public class Tab1NativeHTML extends VerticalLayout {

    public Tab1NativeHTML() {
        // Build a raw <canvas> element and configure it from Java
        Element canvas = new Element("canvas");
        canvas.setAttribute("id", "myCanvas");
        canvas.getStyle().setBorder("1px solid #000");
        canvas.setAttribute("width",  "300px");
        canvas.setAttribute("height", "150px");
        canvas.executeJs("""
          const canvas = document.getElementById("myCanvas");
          const ctx = canvas.getContext("2d");
        
          //draw circle
          ctx.beginPath();
          ctx.arc(150, 75, 50, 0, 2 * Math.PI);
          ctx.fillStyle = "red";
          ctx.fill();
        """);

        getElement().appendChild(canvas);
    }
}
