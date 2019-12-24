package com.uniyaz.cinema.ui.views;

import com.uniyaz.cinema.dao.UserDao;
import com.uniyaz.cinema.domain.EnumUserRole;
import com.uniyaz.cinema.domain.User;
import com.uniyaz.cinema.ui.components.Content;
import com.uniyaz.cinema.ui.components.MyComboBox;
import com.uniyaz.cinema.ui.components.MyTextField;
import com.uniyaz.cinema.ui.components.SignButton;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;

public class SignUpView extends VerticalLayout {

    @PropertyId("userName")
    private MyTextField userNameField;

    @PropertyId("name")
    private MyTextField nameField;

    @PropertyId("surname")
    private MyTextField surnameField;

    @PropertyId("userRole")
    private MyComboBox userRoleField;

    @PropertyId("password")
    private PasswordField passwordField;
    private FormLayout mainLayout;

    private BeanItem<User> item;
    private FieldGroup binder;

    public SignUpView(Content content) {

        buildMainLayout(new User());
    }

    public void buildMainLayout(User user) {

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
        userRoleField.addItem(EnumUserRole.ADMIN);
        userRoleField.addItem(EnumUserRole.USER);
        mainLayout.addComponent(userRoleField);

        passwordField = new PasswordField();
        passwordField.setCaption("Şifre");
        passwordField.setNullRepresentation("");
        mainLayout.addComponent(passwordField);

        item = new BeanItem<User>(user);
        binder = new FieldGroup(item);
        binder.bindMemberFields(this);

        SignButton signUpButton = new SignButton("Sign Up");
        mainLayout.addComponent(signUpButton);
        signUpButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                try {
                    binder.commit();
                    User user = item.getBean();

                    UserDao userDao = new UserDao();
                    userDao.saveUser(user);

                    Notification.show("ÜYELİK TAMAMLANDI");

                } catch (FieldGroup.CommitException e) {
                    e.printStackTrace();
                }

                PopupView popupView = new PopupView();
                mainLayout.addComponent(popupView);
            }
        });


    }
}
