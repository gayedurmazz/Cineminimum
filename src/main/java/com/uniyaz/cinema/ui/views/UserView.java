package com.uniyaz.cinema.ui.views;

import com.uniyaz.cinema.dao.AdminDao;
import com.uniyaz.cinema.domain.Movie;
import com.uniyaz.cinema.ui.components.MyLabel;
import com.uniyaz.cinema.ui.components.MyMenuBar;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import java.util.List;

public class UserView extends VerticalLayout {

    private HorizontalLayout optionsLayout;
    private HorizontalLayout showMovieLayout;
    private String userName;

    public UserView(String userName) {
        this.userName = userName;

        buildOptionsView();
        buildShowMoviesView();

    }

    private void buildShowMoviesView() {

        showMovieLayout = new HorizontalLayout();

        AdminDao adminDao = new AdminDao();
        List<Movie> allMovies = adminDao.findAllMovies();
////////////////////////////////////////
        ///////////////////////////////// filmlerin listelenmesi

    }

    private void buildOptionsView() {
        optionsLayout = new HorizontalLayout();

        MyLabel nameLabel = new MyLabel(   "Hoşgeldin! " + userName);
        nameLabel.setStyleName(ValoTheme.LABEL_BOLD);
        optionsLayout.addComponent(nameLabel);

        MyMenuBar menuBar = new MyMenuBar();
        menuBar.setAutoOpen(true);
        MenuItem menuItem = menuBar.addItem("Menü", FontAwesome.LIST, null);
        menuItem.addItem("İzlediğim Filmler", FontAwesome.TIMES_CIRCLE, null);
        menuItem.addItem("İzlenecek Filmler", FontAwesome.HEART, null);
        optionsLayout.addComponent(menuBar);

        Button searchBtn = new Button();
        searchBtn.setIcon(FontAwesome.SEARCH);
        searchBtn.setDescription("ARAMA YAP");
        optionsLayout.addComponent(searchBtn);

        Button exitBtn = new Button();
        exitBtn.setIcon(FontAwesome.SIGN_OUT);
        exitBtn.setDescription("ÇIKIŞ YAP");
        optionsLayout.addComponent(exitBtn);

        addComponent(optionsLayout);

        setMargin(true);
        setSpacing(true);
    }
}
