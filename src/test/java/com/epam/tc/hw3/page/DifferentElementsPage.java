package com.epam.tc.hw3.page;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DifferentElementsPage extends AbstractBasePage {

    @FindBy(css = ".label-checkbox:first-of-type")
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

    public void waterCheckboxClick() {
        wait.until(ExpectedConditions.visibilityOf(waterCheckbox));
        waterCheckbox.click();
    }

    public void windCheckboxClick() {
        windCheckbox.click();
    }

    public void radioItemClick() {
        radioItem.click();
    }

    public void colorInputButtonClick() {
        colorInputButton.click();
        wait.until(ExpectedConditions.visibilityOf(yellowButton));
    }

    public void yellowButtonClick() {
        yellowButton.click();
    }

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
