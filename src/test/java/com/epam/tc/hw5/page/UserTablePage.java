package com.epam.tc.hw5.page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTablePage extends AbstractBasePage {

    @FindBy(css = "tbody tr td:nth-child(1)")
    List<WebElement> sixNumberTypes;

    @FindBy(css = "td a[href]")
    List<WebElement> sixUserNames;

    @FindBy(css = "td div.user-descr span")
    List<WebElement> sixDescriptionTexts;

    @FindBy(css = "div.user-descr input")
    List<WebElement> sixCheckboxes;

    @FindBy(xpath = "//a[text()='Roman']/../..//select/option")
    List<WebElement> dropdownValuesForUserRoman;

    @FindBy(id = "ivan")
    WebElement checkboxForIvan;

    @FindBy(css = ".logs li")
    List<WebElement> logRowOnUserTablePage;

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public boolean areNumberTypesDisplayed() {
        for (WebElement numberType : sixNumberTypes) {
            if (!numberType.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean areDescriptionTextsDisplayed() {
        for (WebElement descriptionText : sixDescriptionTexts) {
            if (!descriptionText.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean areUserNamesDisplayed() {
        for (WebElement userName : sixUserNames) {
            if (!userName.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean areCheckboxesDisplayed() {
        for (WebElement checkbox : sixCheckboxes) {
            if (!checkbox.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public List<String> getNumberColumn() {
        return sixNumberTypes
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getUserNameColumn() {
        return sixUserNames
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getDescriptionColumn() {
        return sixDescriptionTexts
                .stream()
                .map(WebElement::getText)
                .map(x -> x.replace("\n", " "))
                .collect(Collectors.toList());
    }

    public List<String> getDropdownValuesForUserRoman() {
        return dropdownValuesForUserRoman
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void selectVipCheckboxForUser() {
        wait.until(visibilityOf(checkboxForIvan)).click();
    }

    public List<String> logRowShouldBeVisible() {
        return logRowOnUserTablePage
                .stream()
                .map(WebElement::getText)
                .map(x -> x.substring(9))
                .collect(Collectors.toList());
    }
}
