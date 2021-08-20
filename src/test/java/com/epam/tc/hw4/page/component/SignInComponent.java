package com.epam.tc.hw4.page.component;

import com.epam.tc.hw4.page.AbstractBasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInComponent extends AbstractBasePage {

    @FindBy(id = "name")
    WebElement loginInputButton;

    @FindBy(id = "password")
    WebElement passwordInputButton;

    @FindBy(xpath = "//span[text()='Enter']")
    WebElement enterButton;

    public SignInComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Verify login with login {Utils.LOGIN} and password {Utils.PASSWORD}")
    public void loginValidUser(String login, String password) {
        wait.until(ExpectedConditions.visibilityOf(loginInputButton));
        loginInputButton.sendKeys(login);
        passwordInputButton.sendKeys(password);
        enterButton.click();
    }
}
