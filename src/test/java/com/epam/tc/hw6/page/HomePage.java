package com.epam.tc.hw6.page;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractBasePage {

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

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        open("");
    }

    public boolean areIndexPageImagesDisplayed() {
        for (WebElement actualImages : imagesOnTheIndexPage) {
            if (!actualImages.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

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

    public boolean isIframeExist() {
        return iframe.isDisplayed();
    }

    public void switchToIframe() {
        driver.switchTo().frame(iframe);
    }

    public boolean isFrameButtonExist() {
        return frameButton.isDisplayed();
    }

    public void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
    }

    public List<String> itemsInTheLeftSection() {
        return allItemsInTheLeftSection
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public boolean areLeftSectionItemsDisplayed() {
        for (WebElement actualItem : allItemsInTheLeftSection) {
            if (!actualItem.isDisplayed()) {
                return false;
            }
        }
        return true;
    }
}
