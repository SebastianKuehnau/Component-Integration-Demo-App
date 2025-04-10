package org.vaadin.demo.views.webcomponent;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

/**
 * A Java wrapper for the <model-viewer> Web Component.
 *<p>
 * This class demonstrates how to use a client-side Web Component in a
 * Vaadin Flow application. It uses the @Tag annotation to bind the Java class
 * to the custom element, and @JsModule / @NpmPackage to load the module from npm.
 *<p>
 * The model-viewer component is provided by Google and allows rendering interactive
 * 3D models in the browser. This wrapper makes it usable from Java code.
 *<p>
 * The link to the model-viewer component is the following:
 * <a href="https://www.webcomponents.org/element/@google/model-viewer">link</a>
 *
 */
@NpmPackage(value = "@google/model-viewer", version = "v4.1.0")
@JsModule("@google/model-viewer/dist/model-viewer.min.js")
@Tag("model-viewer")
public class ModelViewer extends Component implements HasSize {

    public ModelViewer(String src) {

        //set attributes of the model viewer
        getElement().setAttribute("src", src);
        getElement().setAttribute("alt", "3D Modell");
        getElement().setAttribute("auto-rotate", true);
        getElement().setAttribute("camera-controls", true);
        getElement().setAttribute("style", "width: 100%; height: 100%");
    }
}
