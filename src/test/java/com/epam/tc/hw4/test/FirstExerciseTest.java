package com.epam.tc.hw4.test;

import com.epam.tc.hw4.Constants;
import com.epam.tc.hw4.Utils;
import com.epam.tc.hw4.page.MainMenuPage;
import com.epam.tc.hw4.page.component.HeaderComponent;
import com.epam.tc.hw4.page.component.SignInComponent;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FirstExerciseTest extends BaseTest {

    @Severity(SeverityLevel.BLOCKER)
    @Feature("Login")
    @Story("Valid login")
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
