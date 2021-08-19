package com.epam.tc.hw4.page.component;

import com.epam.tc.hw4.page.AbstractBasePage;
import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderComponent extends AbstractBasePage {

    @FindBy(xpath = "//div[@class='profile-photo']/following-sibling::span")
    WebElement signInButton;

    @FindBy(css = "#user-name")
    WebElement userNameButton;

    @FindBy(css = "ul.nav > li")
    List<WebElement> allItemsOnTheHeaderSection;

    @FindBy(className = "dropdown-toggle")
    WebElement serviceButton;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Clicking on Sign In button")
    public void clickOnSignInButton() {
        signInButton.click();
    }

    @Step("Verify User name is logged in")
    public String checkUserName() {
        return wait.until(ExpectedConditions.visibilityOf(userNameButton)).getText();
    }

    @Step("Verify items on the Header Section")
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

    @Step("Clicking on SERVICE button")
    public void serviceButtonClick() {
        serviceButton.click();
    }
}
