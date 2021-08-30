package com.epam.tc.hw6.test;

import com.epam.tc.hw4.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class SecondExerciseTest extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Feature("Checking elements functionality")
    @Story("Selecting options")
    @Test(testName = "selecting different options")
    public void exerciseTwo() {

        actionStep.openHomePage();
        actionStep.logInToAccount(Utils.LOGIN, Utils.PASSWORD);
        assertionStep.userNameIsLoggedIn();
        actionStep.openDifferentElementsPage();
        actionStep.selectItemsOnDifferentElementsPage();
        assertionStep.logRowsShouldBeVisibleOnDifferentElementsPage();
        assertionStep.actualLogRowsOnDifferentElementsPage();
    }
}
