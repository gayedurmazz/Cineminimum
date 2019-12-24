package com.uniyaz.cinema.ui.components;

import com.uniyaz.MyUI;
import com.uniyaz.cinema.ui.views.PopUpView;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.VerticalLayout;

public class SideBar extends VerticalLayout {
    private Content content;
    public SideBar(Content content) {
        this.content = content;

        PopupView popUpView = new PopupView(new PopUpView(content));
        addComponent(popUpView);

        MyUI myUI = (MyUI) getUI().getCurrent();
        myUI.setPopupView(popUpView);
        addComponent(popUpView);

        setSpacing(true);
        setMargin(true);

    }
}

