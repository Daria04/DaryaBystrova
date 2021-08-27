package com.epam.tc.hw5.page.component;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInComponent extends AbstractComponent {

    @FindBy(id = "name")
    WebElement loginInputButton;

    @FindBy(id = "password")
    WebElement passwordInputButton;

    @FindBy(id = "login-button")
    WebElement enterButton;

    public SignInComponent(WebDriver driver) {
        super(driver);
    }

    public HeaderComponent loginValidUser(String login, String password) {
        wait.until(visibilityOf(loginInputButton)).sendKeys(login);
        wait.until(visibilityOf(passwordInputButton)).sendKeys(password);
        wait.until(visibilityOf(enterButton)).click();
        return new HeaderComponent(driver);
    }
}
