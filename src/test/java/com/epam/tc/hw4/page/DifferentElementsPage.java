package com.epam.tc.hw4.page;

import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DifferentElementsPage extends AbstractBasePage {

    @FindBy(css = ".label-checkbox")
    WebElement waterCheckbox;

    @FindBy(xpath = "//label[@class='label-checkbox']/following-sibling::label/following-sibling::label")
    WebElement windCheckbox;

    @FindBy(css = ".label-radio:last-of-type")
    WebElement radioItem;

    @FindBy(css = "select.uui-form-element")
    WebElement colorInputButton;

    @FindBy(css = ".colors option:last-of-type")
    WebElement yellowButton;

    @FindBy(css = "ul.logs > li")
    List<WebElement> logRows;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Selecting Water and Wind checkboxes")
    public void checkboxesClick() {
        wait.until(ExpectedConditions.visibilityOf(waterCheckbox));
        waterCheckbox.click();
        windCheckbox.click();
    }

    @Step("Selecting Selen radio item")
    public void radioItemClick() {
        radioItem.click();
    }

    @Step("Selecting Yellow in dropdown")
    public void yellowButtonClick() {
        colorInputButton.click();
        wait.until(ExpectedConditions.visibilityOf(yellowButton));
        yellowButton.click();
    }

    @Step("Verify Log Rows")
    public boolean areLogRowsDisplayed() {
        for (WebElement logRow : logRows) {
            if (!logRow.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public List<String> actualLogRows() {
        return logRows
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
