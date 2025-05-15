package org.vaadin.demo.views.demo.tabs;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Element;

public class Tab1NativeHTML extends VerticalLayout {

    public Tab1NativeHTML() {
        /*** Canvas ***/
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
