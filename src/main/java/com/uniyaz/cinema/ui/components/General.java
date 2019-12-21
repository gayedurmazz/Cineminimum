package com.uniyaz.cinema.ui.components;

import com.uniyaz.MyUI;
import com.uniyaz.cinema.ui.views.PopUpView;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.VerticalLayout;

public class General extends VerticalLayout {

    public General(){

        setWidth(100,Unit.PERCENTAGE);
        setHeight(100, Unit.PERCENTAGE );

        Header header = new Header();
        addComponent(header);

        Container container = new Container();
        addComponent(container);

        setExpandRatio(header, 2f);
        setExpandRatio(container, 8f);

//        Footer footer = new Footer();
//        addComponent(footer);
    }
}
