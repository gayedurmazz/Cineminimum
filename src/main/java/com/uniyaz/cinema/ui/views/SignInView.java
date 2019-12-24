package com.uniyaz.cinema.ui.views;

import com.uniyaz.cinema.dao.UserDao;
import com.uniyaz.cinema.domain.EnumUserRole;
import com.uniyaz.cinema.ui.components.Content;
import com.uniyaz.cinema.ui.components.MyComboBox;
import com.uniyaz.cinema.ui.components.MyTextField;
import com.uniyaz.cinema.ui.components.SignButton;
import com.vaadin.ui.*;

public class SignInView extends VerticalLayout {

    private MyTextField userNameField;
    private MyComboBox userRoleField;
    private PasswordField passwordField;
    private FormLayout mainLayout;
    private EnumUserRole userRole;
    private Content content;

    public SignInView(Content content) {
        this.content = content;
        buildMainLayout();

    }

    public void buildMainLayout() {
        mainLayout = new FormLayout();
        addComponent(mainLayout);

        userRoleField = new MyComboBox();
        userRoleField.setCaption("Kullanıcı Yetkinliği");
        userRoleField.addItem(EnumUserRole.ADMIN);
        userRoleField.addItem(EnumUserRole.USER);
        mainLayout.addComponent(userRoleField);

        userNameField = new MyTextField();
        userNameField.setCaption("Kullanıcı Adı");
        mainLayout.addComponent(userNameField);

        passwordField = new PasswordField();
        passwordField.setCaption("Şifre");
        passwordField.setNullRepresentation("");
        mainLayout.addComponent(passwordField);

        SignButton signInButton = new SignButton("Sign In");
        mainLayout.addComponent(signInButton);
        signInButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                boolean loginAllowed;
                UserDao userDao = new UserDao();
                loginAllowed = userDao.isLoginAllowed(userNameField.getValue(), passwordField.getValue());
                if (loginAllowed && userRoleField.getValue().equals(userRole.ADMIN) ){
                    AdminView adminView = new AdminView(userNameField.getValue());
                    content.setContent(adminView);
                    Notification.show("ADMİN GİRİŞİ YAPILDI");
                }else if(loginAllowed && userRoleField.getValue().equals(userRole.USER)){

                    UserView userView = new UserView(userNameField.getValue());
                    content.setContent(userView);
                    Notification.show("USER GİRİŞİ YAPILDI");
                }else {
                    Notification.show("GİRİŞ BAŞARISIZ!");
                }
            }
        });
    }
}