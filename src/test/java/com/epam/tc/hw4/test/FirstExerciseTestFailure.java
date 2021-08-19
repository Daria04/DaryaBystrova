package com.epam.tc.hw4.test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw4.Constants;
import com.epam.tc.hw4.Utils;
import com.epam.tc.hw4.page.MainMenuPage;
import com.epam.tc.hw4.page.component.HeaderComponent;
import com.epam.tc.hw4.page.component.SignInComponent;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FirstExerciseTestFailure extends BaseTest {

    @Severity(SeverityLevel.BLOCKER)
    @Feature("Login")
    @Story("Valid login")
    @Test(testName = "surf through main page")
    public void exerciseOne() {

        HeaderComponent headerComponent = PageFactory.initElements(driver, HeaderComponent.class);
        headerComponent.clickOnSignInButton();
        SignInComponent signInComponent = PageFactory.initElements(driver, SignInComponent.class);
        signInComponent.loginValidUser(Utils.LOGIN, Utils.PASSWORD);
        assertThat(headerComponent.checkUserName()).isEqualTo(Constants.EXPECTED_USER_NAME);
        assertThat(headerComponent.areMenuItemsDisplayed());
        assertThat(headerComponent.itemsOnTheHeaderSection())
                .isEqualTo(Constants.EXPECTED_ITEMS_ON_THE_HEADER_SECTION);
        MainMenuPage mainMenuPage = PageFactory.initElements(driver, MainMenuPage.class);
        assertThat(mainMenuPage.areIndexPageImagesDisplayed());
        assertThat(mainMenuPage.areIndexPageTextDisplayed());
        assertThat(mainMenuPage.textOnTheIndexPage())
                .isEqualTo(Constants.ALL_EXPECTED_TEXT_UNDER_IMAGES);
        assertThat(mainMenuPage.isIframeExist());
        mainMenuPage.switchToIframe();
        assertThat(mainMenuPage.isFrameButtonExist());
        mainMenuPage.switchToOriginalWindow();
        assertThat(mainMenuPage.itemsInTheLeftSection())
                .isEqualTo(Constants.EXPECTED_ITEMS_IN_THE_LEFT_SECTION);
        assertThat(mainMenuPage.areLeftSectionItemsDisplayed());
        assertThat(mainMenuPage.isButtonClickDisplayed());
    }
}

