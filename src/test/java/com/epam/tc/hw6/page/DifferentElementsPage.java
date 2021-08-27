package com.epam.tc.hw6.page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DifferentElementsPage extends AbstractBasePage {

    @FindBy(css = ".label-checkbox")
    WebElement waterCheckbox;

    @FindBy(css = ".label-checkbox:nth-of-type(3)")
    WebElement windCheckbox;

    @FindBy(css = ".label-radio:last-of-type")
    WebElement radioSelen;

    @FindBy(css = "select.uui-form-element")
    WebElement colorInputButton;

    @FindBy(css = ".colors option:last-of-type")
    WebElement yellowButton;

    @FindBy(css = "ul.logs > li")
    List<WebElement> logRows;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    public void selectItemsOnDifferentElementsPage() {
        wait.until(visibilityOf(waterCheckbox)).click();
        wait.until(visibilityOf(windCheckbox)).click();
        wait.until(visibilityOf(radioSelen)).click();
        wait.until(visibilityOf(colorInputButton)).click();
        wait.until(visibilityOf(yellowButton)).click();
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
                .map(x -> x.substring(9))
                .collect(Collectors.toList());
    }
}
