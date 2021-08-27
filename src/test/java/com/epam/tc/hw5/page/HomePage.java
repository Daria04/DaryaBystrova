package com.epam.tc.hw5.page;

import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractBasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        open("");
    }
}
