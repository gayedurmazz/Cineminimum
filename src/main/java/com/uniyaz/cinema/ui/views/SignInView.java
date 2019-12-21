package com.uniyaz.cinema.ui.views;

import com.uniyaz.cinema.domain.EnumUserRole;
import com.uniyaz.cinema.ui.components.Content;
import com.uniyaz.cinema.ui.components.MyTextField;
import com.uniyaz.cinema.ui.components.SignButton;
import com.vaadin.ui.*;

public class SignInView extends VerticalLayout {

    private MyTextField userNameField;
    private MyTextField userRoleField;
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

        userRoleField = new MyTextField();
        userRoleField.setCaption("Kullanıcı Yetkinliği");
        mainLayout.addComponent(userRoleField);

        userNameField = new MyTextField();
        userNameField.setCaption("Kullanıcı Adı");
        mainLayout.addComponent(userNameField);

        passwordField = new PasswordField();
        passwordField.setCaption("Şifre");
        mainLayout.addComponent(passwordField);

        SignButton signInButton = new SignButton("Sign In");
        mainLayout.addComponent(signInButton);
        signInButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                if(userRoleField.getValue().equals(userRole.ADMIN.toString())){

                    AdminView adminView = new AdminView(userNameField.getValue());
                    content.setContent(adminView);
                    Notification.show("ADMİN GİRİŞİ YAPILDI");

                }else if(userRoleField.getValue().equals(userRole.USER.toString())){

                    UserView userView = new UserView(userRole.USER.toString());
                    content.setContent(userView);
                    Notification.show("USER GİRİŞİ YAPILDI");
                }else {
                    Notification.show("GİRİŞ BAŞARISIZ");
                }
            }
        });
    }
}