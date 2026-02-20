package org.vaadin.demo.views.misc.components;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.react.ReactAdapterComponent;
import com.vaadin.flow.function.SerializableConsumer;

import java.util.List;

// React adapter with Java→React state (setState) and React→Java custom events.
@NpmPackage(value = "react-spin-wheel", version = "^0.0.7")
@JsModule("./components/misc/react-spin-wheel.tsx")
@Tag("react-spin-wheel")
public class SpinWheelComponent extends ReactAdapterComponent {

    // Java → React: push the item list into React state
    public void setItems(List<String> itemList) {
        setState("items", itemList);
    }

    // React → Java: listen for the custom "onFinishSpin" event from the TSX side
    public void addOnFinishSpin(SerializableConsumer<String> consumer) {
        getElement().addEventListener("onFinishSpin", event -> {
            consumer.accept(event.getEventData().get("event.detail").asString());
        }).addEventData("event.detail");
    }
}
