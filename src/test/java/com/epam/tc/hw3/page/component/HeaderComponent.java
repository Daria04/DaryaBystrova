package com.epam.tc.hw3.page.component;

import com.epam.tc.hw3.page.AbstractBasePage;
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

    public void clickOnSignInButton() {
        signInButton.click();
    }

    public String checkUserName() {
        wait.until(ExpectedConditions.visibilityOf(userNameButton));
        return userNameButton.getText();
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

    public void serviceButtonClick() {
        serviceButton.click();
    }
}
