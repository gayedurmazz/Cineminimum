package com.uniyaz.cinema.ui.views;

import com.uniyaz.cinema.dao.AdminDao;
import com.uniyaz.cinema.domain.Movie;
import com.uniyaz.cinema.ui.components.MyLabel;
import com.uniyaz.cinema.ui.components.MyMenuBar;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.MultiSelectMode;
import com.vaadin.ui.*;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.themes.ValoTheme;

import java.util.Date;
import java.util.List;

public class UserView extends VerticalLayout {

    private HorizontalLayout optionsLayout;
    private HorizontalLayout showMovieLayout;
    private String userName;
    private Table table;
    private IndexedContainer indexedContainer;

    public UserView(String userName) {
        this.userName = userName;

        buildOptionsView();
        buildShowMoviesView();

    }

    private void buildShowMoviesView() {

        showMovieLayout = new HorizontalLayout();

        buildTableContainer();

        buildTable();

        fillTable();

        addComponent(showMovieLayout);

    }

    private void fillTable() {
        AdminDao adminDao = new AdminDao();

        List<Movie> movieList = adminDao.findAllMovies();

        for (Movie movie : movieList) {
            Item item = indexedContainer.addItem(movie);
            item.getItemProperty("id").setValue(movie.getId());
            item.getItemProperty("movie_name").setValue(movie.getMovieName());
            item.getItemProperty("vision_date").setValue(movie.getVisionDate());
            //item.getItemProperty("id_saloon").setValue(movie.getId());

        }
    }

    private void buildTable() {

        table = new Table();
        //, "GÖSTERİM SALONU"
        table.setContainerDataSource(indexedContainer);
        table.setColumnHeaders("ID","FİLM ADI", "VİZYON TARİHİ");
        table.setSelectable(true);
        table.setMultiSelectMode(MultiSelectMode.SIMPLE);
        table.setMultiSelect(false);

//        table.addItemClickListener(new ItemClickEvent.ItemClickListener() {
//            @Override
//            public void itemClick(ItemClickEvent itemClickEvent) {
//                issue = (Issue) itemClickEvent.getItemId();
//
//                addIssueView.fillViewByIssue(issue);
//            }
//        });
//

    }

    private void buildTableContainer() {

        // Movie table
        indexedContainer = new IndexedContainer();
        indexedContainer.addContainerProperty("id", Integer.class, null);
        indexedContainer.addContainerProperty("movie_name", String.class, null);
        indexedContainer.addContainerProperty("vision_date", Date.class, null);
      //   indexedContainer.addContainerProperty("id_saloon", MovieSaloon.class, null);
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
        searchBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                showMovieLayout.addComponent(table);
            }
        });
        optionsLayout.addComponent(searchBtn);

        Button exitBtn = new Button();
        exitBtn.setIcon(FontAwesome.SIGN_OUT);
        exitBtn.setDescription("ÇIKIŞ YAP");
        exitBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                removeAllComponents();
                Notification.show("ÇIKIŞ YAPILDI!");
            }
        });
        optionsLayout.addComponent(exitBtn);

//
//        optionsLayout.setMargin(true);
//        optionsLayout.setSpacing(true);
        optionsLayout.setWidth(100,Unit.PERCENTAGE);

        addComponent(optionsLayout);
    }
}
