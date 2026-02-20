package org.vaadin.demo.views.misc.components;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.react.ReactAdapterComponent;

// Minimal React adapter wrapper — MUI Switch with no Java↔React state exchange.
// @NpmPackage auto-installs the npm dependencies at build time.
@NpmPackage(value = "@mui/material", version = "^7.1.0")
@NpmPackage(value = "@emotion/react", version = "^11.14.0")
@NpmPackage(value = "@emotion/styled", version = "^11.14.0")
@JsModule("./components/misc/react-switch.tsx")
@Tag("react-switch")
public class SwitchComponent extends ReactAdapterComponent {

}
