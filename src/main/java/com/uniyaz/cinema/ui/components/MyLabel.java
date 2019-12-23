package com.uniyaz.cinema.ui.components;

import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;

public class MyLabel extends Label {

    public MyLabel(String header_label) {
        setCaption(header_label);

        setStyleName(ValoTheme.TEXTAREA_ALIGN_CENTER);
        setStyleName(ValoTheme.LABEL_COLORED);
        setStyleName(ValoTheme.LABEL_H1);

    }

}
