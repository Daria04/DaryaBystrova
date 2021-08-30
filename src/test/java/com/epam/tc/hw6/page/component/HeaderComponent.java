package com.epam.tc.hw6.page.component;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends AbstractComponent {

    @FindBy(css = ".dropdown>a[href='#']")
    WebElement signInButton;

    @FindBy(className = "dropdown-toggle")
    WebElement serviceButton;

    @FindBy(css = "#user-name")
    WebElement userNameButton;

    @FindBy(css = "ul.nav > li")
    List<WebElement> allItemsOnTheHeaderSection;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public String checkUserName() {
        return wait.until(visibilityOf(userNameButton)).getText();
    }

    public SignInComponent clickToSignInButton() {
        wait.until(visibilityOf(signInButton)).click();
        return new SignInComponent(driver);
    }

    public ServiceComponent clickToServiceButton() {
        wait.until(visibilityOf(serviceButton)).click();
        return new ServiceComponent(driver);
    }

    public boolean areMenuItemsDisplayed() {
        for (WebElement actualItem : allItemsOnTheHeaderSection) {
            if (!actualItem.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public List<String> itemsOnTheHeaderSection() {
        return allItemsOnTheHeaderSection
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
