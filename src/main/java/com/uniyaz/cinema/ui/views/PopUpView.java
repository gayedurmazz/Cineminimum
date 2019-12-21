package com.uniyaz.cinema.ui.views;

import com.uniyaz.cinema.ui.components.Content;
import com.uniyaz.cinema.ui.components.SignButton;
import com.vaadin.ui.*;

public class PopUpView implements PopupView.Content {

    FormLayout mainLayout ;
    private Content content;

    public PopUpView(Content content) {
        this.content = content;
        mainLayout = new FormLayout();

        SignButton signInBtn = new SignButton("GİRİŞ YAP");
        mainLayout.addComponent(signInBtn);
        signInBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                SignInView signInView = new SignInView(content);
                content.setContent(signInView);
            }
        });

        SignButton signUpBtn = new SignButton("ÜYE OL");
        mainLayout.addComponent(signUpBtn);
        signUpBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                SignUpView signUpView = new SignUpView(content);
                content.setContent(signUpView);
            }
        });
    }

    @Override
    public String getMinimizedValueAsHTML() {
        return "KULLANICI İŞLEMLERİ";
    }

    @Override
    public Component getPopupComponent() {
        return mainLayout;
    }
}
