package org.vaadin.demo.views.embed;

import com.vaadin.flow.component.html.IFrame;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@Menu(icon = LineAwesomeIconUrl.YOUTUBE_SQUARE)
@Route("embed")
public class EmbedView extends VerticalLayout {
    public EmbedView() {
        var youtubeEmbed = new IFrame("Youtube embed");
        youtubeEmbed.setWidth("1582px");
        youtubeEmbed.setHeight("890px");
        youtubeEmbed.setSrc("https://www.youtube.com/embed/YDzz6xJ8Sds");
        youtubeEmbed.setTitle("What is Vaadin? The most productive way to build full-stack web apps on Java in 2025");
        youtubeEmbed.getElement().setAttribute("frameborder", "0");
        youtubeEmbed.setAllow("accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share");
        youtubeEmbed.getElement().setAttribute("referrerpolicy", "strict-origin-when-cross-origin");
        youtubeEmbed.getElement().setAttribute("allowfullscreen", "true");

        add(youtubeEmbed);
        setSizeFull();
    }
}
