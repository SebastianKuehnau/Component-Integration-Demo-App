package org.vaadin.demo.views.misc;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.demo.views.misc.tabs.*;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

// Tab-based showcase of different integration patterns (one pattern per tab).
@PageTitle("Misc Components Demo View")
@Menu(title = "Misc Components Demo View", order = 3, icon = LineAwesomeIconUrl.FILM_SOLID)
@Route("demo")
public class MiscComponentsView extends VerticalLayout {

    public MiscComponentsView() {
        var tabSheet = new TabSheet();

        tabSheet.add("Native HTML", new Tab1NativeHTML());
        tabSheet.add("JS Component", new Tab2JsComponent());
        tabSheet.add("React Component (Switch)", new Tab3ReactComponent());
        tabSheet.add("Web Component", new Tab4WebComponent());
        tabSheet.add("React Playground (Spin-Wheel)", new Tab5ReactPlayground());
        tabSheet.add("Extended JS Component", new Tab6ExtJsComponent());

        add(tabSheet);
    }
}
