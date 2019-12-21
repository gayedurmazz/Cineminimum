package com.uniyaz.cinema.ui.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;

public class SignButton extends Button {

    public SignButton(String caption) {
        setIcon(FontAwesome.CHECK);
        setCaption(caption);
    }

}
