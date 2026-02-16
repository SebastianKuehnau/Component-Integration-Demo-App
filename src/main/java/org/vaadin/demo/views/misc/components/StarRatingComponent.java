package org.vaadin.demo.views.misc.components;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.shared.Registration;

@JsModule("./components/misc/star-rating.js")
@Tag("star-rating")
public class StarRatingComponent extends Component implements HasSize {

    public void setMaxStars(int maxStars) {
        getElement().setAttribute("max-stars", String.valueOf(maxStars));
    }

    public int getRating() {
        return getElement().getProperty("rating", 0);
    }

    public void setRating(int rating) {
        getElement().setProperty("rating", rating);
    }

    public Registration addRatingChangedListener(
            ComponentEventListener<RatingChangedEvent> listener) {
        return addListener(RatingChangedEvent.class, listener);
    }

    @DomEvent("rating-changed")
    public static class RatingChangedEvent extends ComponentEvent<StarRatingComponent> {
        private final int value;

        public RatingChangedEvent(StarRatingComponent source,
                                  boolean fromClient,
                                  @EventData("event.detail.value") int value) {
            super(source, fromClient);
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}