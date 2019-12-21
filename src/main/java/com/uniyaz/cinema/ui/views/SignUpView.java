package com.uniyaz.cinema.ui.views;

import com.uniyaz.cinema.dao.UserDao;
import com.uniyaz.cinema.domain.EnumUserRole;
import com.uniyaz.cinema.domain.User;
import com.uniyaz.cinema.ui.components.*;
import com.vaadin.ui.*;

public class SignUpView extends VerticalLayout {

    private MyTextField userNameField;
    private MyTextField nameField;
    private MyTextField surnameField;
    private MyComboBox userRoleField;
    private PasswordField passwordField;
    private FormLayout mainLayout;

    public SignUpView(Content content) {

        buildMainLayout();
    }

    public void buildMainLayout() {
        mainLayout = new FormLayout();
        addComponent(mainLayout);

        userNameField = new MyTextField();
        userNameField.setCaption("Kullanıcı Adı");
        mainLayout.addComponent(userNameField);

        nameField = new MyTextField();
        nameField.setCaption("Adınız");
        mainLayout.addComponent(nameField);

        surnameField = new MyTextField();
        surnameField.setCaption("Soyadınız");
        mainLayout.addComponent(surnameField);

        userRoleField = new MyComboBox();
        userRoleField.setCaption("Kullanıcı Yetkiniz");
        mainLayout.addComponent(userRoleField);

        passwordField = new PasswordField();
        passwordField.setCaption("Şifre");
        mainLayout.addComponent(passwordField);

        SignButton signUpButton = new SignButton("Sign In");
        mainLayout.addComponent(signUpButton);
        signUpButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                User user = new User();
                user.setName(nameField.getValue());
                user.setSurname(surnameField.getValue());
                user.setPassword(passwordField.getValue());
                user.setUserName(userNameField.getValue());
                user.setUserRole((EnumUserRole) userRoleField.getValue());

                UserDao userDao = new UserDao();
                userDao.saveUser(user);

                Notification.show("ÜYELİK TAMAMLANDI");
            }
        });


    }
}
