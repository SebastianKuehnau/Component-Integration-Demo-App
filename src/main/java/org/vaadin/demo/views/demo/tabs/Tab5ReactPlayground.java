package org.vaadin.demo.views.demo.tabs;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.vaadin.demo.views.demo.components.SpinWheelComponent;

import java.util.List;

public class Tab5ReactPlayground extends VerticalLayout {

    public Tab5ReactPlayground() {
        List<String> nameList = List.of("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Heidi", "Ivan", "Judy");
        ComboBox<String> nameComboBox = new ComboBox<>();nameComboBox.setItems(nameList);
        add(nameComboBox);

        add(new SpinWheelComponent());
    }
}
