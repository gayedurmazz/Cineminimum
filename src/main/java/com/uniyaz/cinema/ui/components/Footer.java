package com.uniyaz.cinema.ui.components;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class Footer extends HorizontalLayout {

    public Footer() {
        MyLabel label = new MyLabel("Footer Label");
        label.setStyleName(ValoTheme.TEXTAREA_ALIGN_CENTER);
        addComponent(label);
    }
}
