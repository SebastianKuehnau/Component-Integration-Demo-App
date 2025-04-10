package org.vaadin.demo.views.webcomponent;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

/**
 * A Vaadin view demonstrating the use of a custom Web Component in a Flow UI.
 * <p>
 * This view shows how to integrate a third-party Web Component (model-viewer)
 * into a Vaadin application using a Java wrapper component (ModelViewer).
 * <p>
 * The ModelViewer component wraps the <model-viewer> Web Component from Google's
 * model-viewer project (<a href="https://github.com/google/model-viewer">...</a>) and exposes it as
 * a Java component that can be used like any other Vaadin UI element.
 */
@PageTitle("Web Component")
@Route("web-component")
@Menu(order = 1, icon = LineAwesomeIconUrl.SPACE_SHUTTLE_SOLID)
public class WebComponentView extends VerticalLayout {

    public WebComponentView() {

        String modelUrl = "https://modelviewer.dev/shared-assets/models/NeilArmstrong.glb";
        ModelViewer viewer = new ModelViewer(modelUrl);
        add(viewer);

        setSizeFull();
    }
}
