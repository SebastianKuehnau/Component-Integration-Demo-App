package org.vaadin.demo.views.demo;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.demo.views.demo.tabs.Tab1NativeHTML;
import org.vaadin.demo.views.demo.tabs.Tab2JsComponent;
import org.vaadin.demo.views.demo.tabs.Tab3ReactComponent;
import org.vaadin.demo.views.demo.tabs.Tab4WebComponent;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Demo View")
@Menu(title = "Demo View", order = 8, icon = LineAwesomeIconUrl.FILM_SOLID)
@Route("demo")
public class DemoView extends VerticalLayout {

    public DemoView() {
        var tabSheet = new TabSheet();
        tabSheet.add("Native HTML", new Tab1NativeHTML());
        tabSheet.add("JS Component", new Tab2JsComponent());
        tabSheet.add("React Component", new Tab3ReactComponent());
        tabSheet.add("Web Component", new Tab4WebComponent());

        add(tabSheet);
    }
}
