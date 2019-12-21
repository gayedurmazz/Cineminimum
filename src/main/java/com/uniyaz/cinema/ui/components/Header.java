package com.uniyaz.cinema.ui.components;

import com.uniyaz.MyUI;
import com.uniyaz.cinema.ui.views.PopUpView;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class Header extends HorizontalLayout {


    public Header() {

        MyLabel label = new MyLabel("HOŞGELDİNİZ");

        label.setStyleName(ValoTheme.TEXTFIELD_ALIGN_RIGHT);
        label.setStyleName(ValoTheme.LABEL_COLORED);
        label.setStyleName(ValoTheme.LABEL_H1);

        addComponent(label);

    }
}
