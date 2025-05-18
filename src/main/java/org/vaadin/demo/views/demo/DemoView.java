package org.vaadin.demo.views.demo;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.demo.views.demo.tabs.*;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Demo View")
@Menu(title = "Demo View", order = 0, icon = LineAwesomeIconUrl.FILM_SOLID)
@Route("demo")
@RouteAlias("")
public class DemoView extends VerticalLayout {

    public DemoView() {
        var tabSheet = new TabSheet();

        tabSheet.add("React Playground", new Tab5ReactPlayground());

        tabSheet.add("Native HTML", new Tab1NativeHTML());
        tabSheet.add("JS Component", new Tab2JsComponent());
        tabSheet.add("React Component", new Tab3ReactComponent());
        tabSheet.add("Web Component", new Tab4WebComponent());

        add(tabSheet);
    }
}
