package org.vaadin.demo.views.demo.tabs;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.vaadin.demo.views.demo.components.SpinWheelComponent;

import java.util.List;

public class Tab5ReactPlayground extends VerticalLayout {

    public Tab5ReactPlayground() {
        List<String> nameList = List.of("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Heidi", "Ivan", "Judy");
        ComboBox<String> nameComboBox = new ComboBox<>();nameComboBox.setItems(nameList);
        add(nameComboBox);

        SpinWheelComponent spinWheelComponent = new SpinWheelComponent();
        spinWheelComponent.setItems(nameList);
        spinWheelComponent.addOnFinishSpin(name -> {
            Notification.show("You have won: " + name)
                .addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            nameComboBox.setValue(name);
        });

        add(spinWheelComponent);
    }
}
