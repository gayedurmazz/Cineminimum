package com.uniyaz.cinema.ui.views;

import com.uniyaz.cinema.dao.AdminDao;
import com.uniyaz.cinema.domain.Movie;
import com.uniyaz.cinema.ui.components.MyLabel;
import com.uniyaz.cinema.ui.components.MyTextField;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.Date;

public class AdminView extends VerticalLayout {

    private HorizontalLayout optionsLayout;
    private FormLayout formLayout;
    private String userName;
    public AdminView(String userName) {

        this.userName = userName;
        ///// Menü seçenekleri
        optionsLayout = new HorizontalLayout();

        MyLabel nameLabel = new MyLabel(   "Hoşgeldin! " + userName);
        nameLabel.setStyleName(ValoTheme.LABEL_BOLD);
        optionsLayout.addComponent(nameLabel);

        Button addMovieBtn = new Button();
        addMovieBtn.setIcon(FontAwesome.PLUS_SQUARE);
        addMovieBtn.setDescription("Film Ekle");
        addMovieBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                buildAddFormLayout();
            }
        });
        optionsLayout.addComponent(addMovieBtn);

        Button searchBtn = new Button();
        searchBtn.setIcon(FontAwesome.SEARCH);
        searchBtn.setDescription("Filmleri Listele");
        searchBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

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

        optionsLayout.setMargin(true);
        optionsLayout.setSpacing(true);
        optionsLayout.setWidth(100,Unit.PERCENTAGE);
        addComponent(optionsLayout);
    }

    private void buildAddFormLayout() {
        formLayout = new FormLayout();

        MyTextField idField = new MyTextField();
        idField.setCaption("Film ID'si");
        formLayout.addComponent(idField);

        MyTextField movieNameField = new MyTextField();
        movieNameField.setCaption("Filmin Adı");
        formLayout.addComponent(movieNameField);

        DateField visionDateField = new DateField();
        visionDateField.setCaption("Vizyon Tarihi");
        formLayout.addComponent(visionDateField);


        Button saveButton = new Button();
        saveButton.setCaption("KAYDET");
        formLayout.addComponent(saveButton);
        saveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                String movieNameFieldValue = movieNameField.getValue();
                Date visionDateFieldValue = visionDateField.getValue();

                Movie movie = new Movie();
                movie.setMovieName(movieNameFieldValue);
                movie.setVisionDate(visionDateFieldValue);

                AdminDao adminDao = new AdminDao();
                adminDao.saveMovie(movie);
//                idField.setValue(movie.getId().);
                Notification.show("Film Başarıyla Kaydedildi.");
            }
        });

        addComponent(formLayout);
    }
}
