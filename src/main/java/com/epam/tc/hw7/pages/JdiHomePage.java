package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.forms.LoginForm;

public class JdiHomePage extends WebPage {

    private LoginForm loginForm;

    @UI("#user-icon")
    public Icon userIcon;

    @UI("#user-name")
    public Label userName;

    public void login(User user) {
        userIcon.click();
        loginForm.login(user);
    }
}
