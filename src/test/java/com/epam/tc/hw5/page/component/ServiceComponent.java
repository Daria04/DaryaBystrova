package com.epam.tc.hw5.page.component;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import com.epam.tc.hw5.page.DifferentElementsPage;
import com.epam.tc.hw5.page.UserTablePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServiceComponent extends AbstractComponent {

    @FindBy(xpath = "//a[@href='different-elements.html']")
    WebElement differentElementsButton;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//a[@href='user-table.html']")
    WebElement userTableButton;

    public ServiceComponent(WebDriver driver) {
        super(driver);
    }

    public DifferentElementsPage clickToDifferentElementsButton() {
        wait.until(visibilityOf(differentElementsButton)).click();
        return new DifferentElementsPage(driver);
    }

    public UserTablePage clickToUserTableButton() {
        wait.until(visibilityOf(userTableButton)).click();
        return new UserTablePage(driver);
    }
}
