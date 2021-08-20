package com.epam.tc.hw4.page;

import com.epam.tc.hw4.Constants;
import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenuPage extends AbstractBasePage {

    @FindBy(className = "benefit-icon")
    List<WebElement> imagesOnTheIndexPage;

    @FindBy(className = "benefit-txt")
    List<WebElement> textUnderImagesOnTheIndexPage;

    @FindBy(id = "frame")
    WebElement iframe;

    @FindBy(id = "frame-button")
    WebElement frameButton;

    @FindBy(css = "ul.left > li")
    List<WebElement> allItemsInTheLeftSection;

    @FindBy(css = "input[value='Button']")
    WebElement buttonClick;

    public MainMenuPage(WebDriver driver) {
        super(driver);
        if (!driver.getTitle().equals(Constants.EXPECTED_TITLE)) {
            throw new IllegalArgumentException("Current page is: " + driver.getCurrentUrl());
        }
    }

    @Step("Verify images on the Index Page")
    public boolean areIndexPageImagesDisplayed() {
        for (WebElement actualImages : imagesOnTheIndexPage) {
            if (!actualImages.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    @Step("Verify text on the Index Page")
    public boolean areIndexPageTextDisplayed() {
        for (WebElement actualText : textUnderImagesOnTheIndexPage) {
            if (!actualText.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public List<String> textOnTheIndexPage() {
        return textUnderImagesOnTheIndexPage
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @Step("Verify iframe existing")
    public boolean isIframeExist() {
        return iframe.isDisplayed();
    }

    @Step("Switch to iframe")
    public void switchToIframe() {
        driver.switchTo().frame(iframe);
    }

    @Step("Verify Frame Button in the iframe")
    public boolean isFrameButtonExist() {
        return frameButton.isDisplayed();
    }

    @Step("Switch to original window")
    public void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
    }

    public List<String> itemsInTheLeftSection() {
        return allItemsInTheLeftSection
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @Step("Verify items in the Left Section")
    public boolean areLeftSectionItemsDisplayed() {
        for (WebElement actualItem : allItemsInTheLeftSection) {
            if (!actualItem.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    @Step("Verify buttonClick on the Index Page")
    public boolean isButtonClickDisplayed() {
        return buttonClick.isDisplayed();
    }
}
