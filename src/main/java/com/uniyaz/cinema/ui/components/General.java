package com.uniyaz.cinema.ui.components;

import com.vaadin.ui.VerticalLayout;

public class General extends VerticalLayout {

    public General(){

        Header header = new Header();
        addComponent(header);

        Container container = new Container();
        addComponent(container);

//        setExpandRatio(header, 2f);
//        setExpandRatio(container, 8f);
//
//        setWidth(100,Unit.PERCENTAGE);
//        setHeight(100, Unit.PERCENTAGE );

//        Footer footer = new Footer();
//        addComponent(footer);
    }
}
