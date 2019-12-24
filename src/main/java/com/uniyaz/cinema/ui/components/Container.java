package com.uniyaz.cinema.ui.components;

import com.vaadin.ui.HorizontalLayout;

public class Container extends HorizontalLayout {

    private Header header;

    public Container() {

        this.header = header;
        setWidth(100, Unit.PERCENTAGE);

        Content content = new Content();
        SideBar sideBar = new SideBar(content);

        content.setMargin(true);
        sideBar.setMargin(true);

        addComponent(sideBar);
        addComponent(content);


        setExpandRatio(sideBar, 2f);
        setExpandRatio(content,8f);

    }
}
