package com.epam.tc.hw3.page.component;

import com.epam.tc.hw3.page.AbstractBasePage;
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

    public void loginValidUser(String login, String password) {
        typeLoginData(login);
        typePassword(password);
        clickOnEnterButton();
    }

    private void typeLoginData(String login) {
        wait.until(ExpectedConditions.visibilityOf(loginInputButton));
        loginInputButton.sendKeys(login);
    }

    private void typePassword(String password) {
        passwordInputButton.sendKeys(password);
    }

    private void clickOnEnterButton() {
        enterButton.click();
    }
}
