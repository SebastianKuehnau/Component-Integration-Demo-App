package org.vaadin.demo.views.misc.components;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.shared.Registration;

// Vanilla JS custom element wrapper. @JsModule loads the JS, @Tag maps to <star-rating>.
// Communication: Java→JS via setProperty/setAttribute, JS→Java via @DomEvent.
@JsModule("./components/misc/star-rating.js")
@Tag("star-rating")
public class StarRatingComponent extends Component implements HasSize {

    // Java → JS: sets the "max-stars" HTML attribute, observed in star-rating.js
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

    // JS → Java: maps the "rating-changed" CustomEvent from star-rating.js
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