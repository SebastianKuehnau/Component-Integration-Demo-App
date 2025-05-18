package org.vaadin.demo.views.demo.components;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.react.ReactAdapterComponent;

@NpmPackage(value = "react-spin-wheel", version = "^0.0.7")
@JsModule("./components/demo/react-spin-wheel.tsx")
@Tag("react-spin-wheel")
public class SpinWheelComponent extends ReactAdapterComponent {


}
