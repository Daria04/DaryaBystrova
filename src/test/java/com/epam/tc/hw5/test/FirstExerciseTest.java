package com.epam.tc.hw5.test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw4.Utils;
import com.epam.tc.hw5.Constants;
import com.epam.tc.hw5.page.DifferentElementsPage;
import com.epam.tc.hw5.page.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FirstExerciseTest extends AbstractBaseSeleniumTest {

    @Test
    public void selectingDifferentOptions() {

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        DifferentElementsPage differentElementsPage = homePage.clickToSignInButton()
                .loginValidUser(Utils.LOGIN, Utils.PASSWORD)
                .clickToServiceButton()
                .clickToDifferentElementsButton();

        differentElementsPage.selectItemsOnDifferentElementsPage();

        assertThat(differentElementsPage.areLogRowsDisplayed());
        assertThat(differentElementsPage.actualLogRows()
                .containsAll(Constants.EXPECTED_LOG_ROWS));
    }
}
