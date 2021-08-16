package com.epam.tc.hw3.page.component;

import com.epam.tc.hw3.page.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServiceComponent extends AbstractBasePage {

    @FindBy(xpath = "//a[@href='different-elements.html']")
    WebElement differentElementsButton;

    public ServiceComponent(WebDriver driver) {
        super(driver);
    }

    public void difElementsButtonClick() {
        differentElementsButton.click();
    }
}
