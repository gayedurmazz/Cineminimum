package com.uniyaz.cinema.ui.components;

import com.uniyaz.MyUI;
import com.uniyaz.cinema.ui.views.PopUpView;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class SideBar extends VerticalLayout {
    private Content content;
    public SideBar(Content content) {
        this.content = content;
        MyLabel label = new MyLabel("Sidebar Label");
        label.setStyleName(ValoTheme.TEXTAREA_ALIGN_CENTER);
        addComponent(label);

        PopupView popUpView = new PopupView(new PopUpView(content));
        addComponent(popUpView);

        MyUI myUI = (MyUI) getUI().getCurrent();
        myUI.setPopupView(popUpView);
        addComponent(popUpView);

        setSpacing(true);
        setMargin(true);



    }
}

