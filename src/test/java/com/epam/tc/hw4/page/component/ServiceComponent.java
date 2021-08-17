package com.epam.tc.hw4.page.component;

import com.epam.tc.hw4.page.AbstractBasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServiceComponent extends AbstractBasePage {

    @FindBy(xpath = "//a[@href='different-elements.html']")
    WebElement differentElementsButton;

    public ServiceComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Clicking on DIFFERENT ELEMENTS button")
    public void difElementsButtonClick() {
        differentElementsButton.click();
    }
}
