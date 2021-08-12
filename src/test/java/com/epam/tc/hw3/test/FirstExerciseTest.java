package com.epam.tc.hw3.test;

import com.epam.tc.hw3.BaseTest;
import com.epam.tc.hw3.Constants;
import com.epam.tc.hw3.Utils;
import com.epam.tc.hw3.page.MainMenuPage;
import com.epam.tc.hw3.page.component.HeaderComponent;
import com.epam.tc.hw3.page.component.SignInComponent;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FirstExerciseTest extends BaseTest {

    @Test(testName = "surf through main page")
    public void exerciseOne() {

        SoftAssertions softly = new SoftAssertions();

        HeaderComponent headerComponent = PageFactory.initElements(driver, HeaderComponent.class);
        headerComponent.clickOnSignInButton();
        SignInComponent signInComponent = PageFactory.initElements(driver, SignInComponent.class);
        signInComponent.loginValidUser(Utils.LOGIN, Utils.PASSWORD);
        softly.assertThat(headerComponent.checkUserName()).isEqualTo(Constants.EXPECTED_USER_NAME);
        softly.assertThat(headerComponent.areMenuItemsDisplayed());
        softly.assertThat(headerComponent.itemsOnTheHeaderSection())
                .isEqualTo(Constants.EXPECTED_ITEMS_ON_THE_HEADER_SECTION);
        MainMenuPage mainMenuPage = PageFactory.initElements(driver, MainMenuPage.class);
        softly.assertThat(mainMenuPage.areIndexPageImagesDisplayed());
        softly.assertThat(mainMenuPage.areIndexPageTextDisplayed());
        softly.assertThat(mainMenuPage.textOnTheIndexPage())
                .isEqualTo(Constants.ALL_EXPECTED_TEXT_UNDER_IMAGES);
        softly.assertThat(mainMenuPage.isIframeExist());
        mainMenuPage.switchToIframe();
        softly.assertThat(mainMenuPage.isFrameButtonExist());
        mainMenuPage.switchToOriginalWindow();
        softly.assertThat(mainMenuPage.itemsInTheLeftSection())
                .isEqualTo(Constants.EXPECTED_ITEMS_IN_THE_LEFT_SECTION);
        softly.assertThat(mainMenuPage.areLeftSectionItemsDisplayed());

        softly.assertAll();
    }
}
