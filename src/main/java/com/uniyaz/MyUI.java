package com.uniyaz;

import com.uniyaz.cinema.ui.components.General;
import com.uniyaz.cinema.utils.HibernateUtil;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.UI;
import org.hibernate.SessionFactory;

import javax.servlet.annotation.WebServlet;

/**
 *
 */
@Theme("mytheme")
@Widgetset("com.uniyaz.MyAppWidgetset")
public class MyUI extends UI {

    private PopupView popupView;
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        sessionFactory.openSession();
        General general = new General();
        setContent(general);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

    public PopupView getPopupView() {
        return popupView;
    }

    public void setPopupView(PopupView popupView) {
        this.popupView = popupView;
    }
}
