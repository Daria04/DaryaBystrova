package com.epam.tc.hw3.test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw3.BaseTest;
import com.epam.tc.hw3.Constants;
import com.epam.tc.hw3.Utils;
import com.epam.tc.hw3.page.DifferentElementsPage;
import com.epam.tc.hw3.page.component.HeaderComponent;
import com.epam.tc.hw3.page.component.ServiceComponent;
import com.epam.tc.hw3.page.component.SignInComponent;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SecondExerciseTest extends BaseTest {

    @Test(testName = "select different options")
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
        differentElements.waterCheckboxClick();
        differentElements.windCheckboxClick();
        differentElements.radioItemClick();
        differentElements.colorInputButtonClick();
        differentElements.yellowButtonClick();
        assertThat(differentElements.areLogRowsDisplayed());
    }
}
