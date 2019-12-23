package com.uniyaz.cinema.ui.components;

import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class Header extends VerticalLayout {


    public Header() {

        setWidth(100, Unit.PERCENTAGE);
        setHeight(100, Unit.PIXELS);
        MyLabel label = new MyLabel("CINEMINIMUM'A HOŞGELDİNİZ");
        label.setStyleName(ValoTheme.TEXTAREA_ALIGN_RIGHT);
        setSpacing(true);
        setMargin(true);
        addComponent(label);

    }
}
