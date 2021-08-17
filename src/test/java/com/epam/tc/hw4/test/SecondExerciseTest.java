package com.epam.tc.hw4.test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw4.Constants;
import com.epam.tc.hw4.Utils;
import com.epam.tc.hw4.page.DifferentElementsPage;
import com.epam.tc.hw4.page.component.HeaderComponent;
import com.epam.tc.hw4.page.component.ServiceComponent;
import com.epam.tc.hw4.page.component.SignInComponent;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SecondExerciseTest extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Feature("Checking elements functionality")
    @Story("Selecting options")
    @Test(testName = "selecting different options")
    public void exerciseTwo() {

        HeaderComponent headerComponent = PageFactory.initElements(driver, HeaderComponent.class);
        headerComponent.clickOnSignInButton();
        SignInComponent signInComponent = PageFactory.initElements(driver, SignInComponent.class);
        signInComponent.loginValidUser(Utils.LOGIN, Utils.PASSWORD);
        assertThat(headerComponent.checkUserName()).isEqualTo(Constants.EXPECTED_USER_NAME);
        headerComponent.serviceButtonClick();
        ServiceComponent serviceComponent = PageFactory.initElements(driver, ServiceComponent.class);
        serviceComponent.difElementsButtonClick();
        DifferentElementsPage differentElements = PageFactory.initElements(driver, DifferentElementsPage.class);
        differentElements.checkboxesClick();
        differentElements.radioItemClick();
        differentElements.yellowButtonClick();
        assertThat(differentElements.areLogRowsDisplayed());
        assertThat(differentElements.actualLogRows().containsAll(Constants.EXPECTED_LOG_ROWS));
    }
}
