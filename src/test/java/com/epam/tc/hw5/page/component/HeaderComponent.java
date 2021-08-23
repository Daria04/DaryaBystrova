package com.epam.tc.hw5.page.component;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends AbstractComponent {

    @FindBy(css = ".dropdown>a[href='#']")
    WebElement signInButton;

    @FindBy(className = "dropdown-toggle")
    WebElement serviceButton;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public SignInComponent clickToSignInButton() {
        wait.until(visibilityOf(signInButton)).click();
        return new SignInComponent(driver);
    }

    public ServiceComponent clickToServiceButton() {
        wait.until(visibilityOf(serviceButton)).click();
        return new ServiceComponent(driver);
    }
}
