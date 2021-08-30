package com.epam.tc.hw6.page.component;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import com.epam.tc.hw6.page.DifferentElementsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServiceComponent extends AbstractComponent {

    @FindBy(xpath = "//a[@href='different-elements.html']")
    WebElement differentElementsButton;

    public ServiceComponent(WebDriver driver) {
        super(driver);
    }

    public DifferentElementsPage clickToDifferentElementsButton() {
        wait.until(visibilityOf(differentElementsButton)).click();
        return new DifferentElementsPage(driver);
    }
}
