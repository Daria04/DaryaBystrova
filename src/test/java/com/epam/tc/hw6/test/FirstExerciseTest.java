package com.epam.tc.hw6.test;

import com.epam.tc.hw4.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class FirstExerciseTest extends BaseTest {

    @Severity(SeverityLevel.BLOCKER)
    @Feature("Login")
    @Story("Valid login")
    @Test(testName = "surf through home page")
    public void exerciseOne() {

        actionStep.openHomePage();
        actionStep.logInToAccount(Utils.LOGIN, Utils.PASSWORD);
        assertionStep.userNameIsLoggedIn();
        assertionStep.itemsOnTheHeaderSectionShouldBeVisible();
        assertionStep.actualItemsOnTheHeaderSection();
        assertionStep.indexPageImagesShouldBeDisplayedOnHomePage();
        assertionStep.textUnderImagesShouldBeDisplayedOnHomePage();
        assertionStep.actualTextUnderImagesOnHomePage();
        assertionStep.iframeShouldBeVisible();
        actionStep.switchToIframeOnHomePage();
        assertionStep.frameButtonShouldBeVisible();
        actionStep.switchToOriginalWindowOnHomePage();
        assertionStep.itemsInTheLeftSectionShouldBeVisible();
    }
}
