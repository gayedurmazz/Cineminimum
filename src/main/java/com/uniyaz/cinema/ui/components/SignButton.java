package com.uniyaz.cinema.ui.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public class SignButton extends Button {

    public SignButton(String caption) {
        setIcon(FontAwesome.CHECK);
        setCaption(caption);
        setStyleName(ValoTheme.BUTTON_FRIENDLY);
    }

}
