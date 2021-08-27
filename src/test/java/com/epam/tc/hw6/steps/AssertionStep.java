package com.epam.tc.hw6.steps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw4.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AssertionStep extends AbstractStep {

    public AssertionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Verify that user is logged in")
    public void userNameIsLoggedIn() {
        assertThat(headerComponent.checkUserName())
                .isEqualTo(Constants.EXPECTED_USER_NAME);
    }

    @Step("Verify items on the Header Section are displayed")
    public void itemsOnTheHeaderSectionShouldBeVisible() {
        assertThat(headerComponent.areMenuItemsDisplayed());
    }

    @Step("Verify items on the Header Section is equal to expected")
    public void actualItemsOnTheHeaderSection() {
        assertThat(headerComponent.itemsOnTheHeaderSection())
                .isEqualTo(Constants.EXPECTED_ITEMS_ON_THE_HEADER_SECTION);
    }

    @Step("Verify images on the Index Page are displayed")
    public void indexPageImagesShouldBeDisplayedOnHomePage() {
        assertThat(homePage.areIndexPageImagesDisplayed());
    }

    @Step("Verify text under images on the Index Page is displayed")
    public void textUnderImagesShouldBeDisplayedOnHomePage() {
        assertThat(homePage.areIndexPageTextDisplayed());
    }

    @Step("Verify text under images is equal to expected")
    public void actualTextUnderImagesOnHomePage() {
        assertThat(homePage.textOnTheIndexPage())
                .isEqualTo(Constants.ALL_EXPECTED_TEXT_UNDER_IMAGES);
    }

    @Step("Verify iframe existing")
    public void iframeShouldBeVisible() {
        assertThat(homePage.isIframeExist());
    }

    @Step("Verify Frame Button in the iframe")
    public void frameButtonShouldBeVisible() {
        assertThat(homePage.isFrameButtonExist());
    }

    @Step("Verify items in the Left Section")
    public void itemsInTheLeftSectionShouldBeVisible() {
        assertThat(homePage.areLeftSectionItemsDisplayed());
    }

    @Step("Verify log rows are displayed")
    public void logRowsShouldBeVisibleOnDifferentElementsPage() {
        assertThat(differentElementsPage.areLogRowsDisplayed());
    }

    @Step("Verify log rows are equal to expected")
    public void actualLogRowsOnDifferentElementsPage() {
        assertThat(differentElementsPage.actualLogRows())
                .isEqualTo(Constants.EXPECTED_LOG_ROWS);
    }
}
