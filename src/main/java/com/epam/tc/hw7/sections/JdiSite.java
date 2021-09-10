package com.epam.tc.hw7.sections;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.pages.JdiHomePage;
import com.epam.tc.hw7.pages.JdiMetalAndColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("index.html") @Title("Home Page")
    public static JdiHomePage jdiHomePage;

    @Url("/metals-colors.html") @Title("Metal and Colors")
    public static JdiMetalAndColorsPage jdiMetalAndColorsPage;

    public static void openHomePage() {
        jdiHomePage.open();
    }

    public static void login(User user) {
        jdiHomePage.login(user);
    }

    public static void openMetalAndColorsPage() {
        jdiMetalAndColorsPage.open();
    }
}
