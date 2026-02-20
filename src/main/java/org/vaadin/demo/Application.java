package org.vaadin.demo;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.aura.Aura;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The entry point of the Spring Boot application.
 * <p>
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */
// AppShellConfigurator: configures the HTML page shell (stylesheets, theme, PWA, etc.)
@StyleSheet(Lumo.STYLESHEET)          // Lumo base theme
@StyleSheet(Lumo.UTILITY_STYLESHEET)  // Lumo utility CSS classes (spacing, sizing, etc.)
@StyleSheet("styles.css")             // Custom app-wide styles (from META-INF/resources/)
@SpringBootApplication
public class Application implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

