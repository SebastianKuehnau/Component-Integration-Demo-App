package org.vaadin.demo.views.demo.components;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.react.ReactAdapterComponent;

@NpmPackage(value = "@mui/material", version = "^7.1.0")
@NpmPackage(value = "@emotion/react", version = "^11.14.0")
@NpmPackage(value = "@emotion/styled", version = "^11.14.0")
@JsModule("./components/demo/react-switch.tsx")
@Tag("react-switch")
public class SwitchComponent extends ReactAdapterComponent {

}
