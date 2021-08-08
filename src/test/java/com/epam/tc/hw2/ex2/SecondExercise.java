package com.epam.tc.hw2.ex2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SecondExercise extends TestService {

    @Test
    public void exerciseTwo() {

        //1. Open test site by URL
        driver.navigate().to(URL);

        //2. Assert Browser title
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(EXPECTED_TITLE);

        //3. Perform login
        WebElement signIn = driver.findElement(SIGN_IN_BUTTON);
        signIn.click();

        WebElement login = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(LOGIN_INPUT_BUTTON));
        login.sendKeys(LOGIN_DATA);

        WebElement password = driver.findElement(PASSWORD_INPUT_BUTTON);
        password.sendKeys(PASSWORD_DATA);

        WebElement enter = driver.findElement(ENTER_BUTTON);
        enter.click();

        //4. Assert User name in the left-top side of screen that user is logged in
        String actualData = driver.findElement(USER_NAME).getText();
        assertThat(actualData).isEqualTo(EXPECTED_DATA);

        //5. Open through the header menu Service -> Different Elements Page
        WebElement serviceItem = driver.findElement(SERVICE_BUTTON);
        serviceItem.click();

        WebElement differentElementsItem = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(DIFFERENT_ELEMENTS_BUTTON));
        differentElementsItem.click();

        //6. Select checkboxes
        WebElement waterItem = driver.findElement(WATER_ITEM_CHECK_BOX);
        waterItem.click();

        WebElement windItem = driver.findElement(WIND_ITEM_CHECK_BOX);
        windItem.click();

        //7. Select radio
        WebElement selenItem = ((new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(SELEN_ITEM_CHECK_BOX)));
        selenItem.click();

        //8. Select in dropdown
        WebElement formElement = driver.findElement(COLOR_INPUT_BUTTON);
        formElement.click();

        //9. Assert that
        // for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        // for radio button there is a log row and value is corresponded to the status of radio button
        // for dropdown there is a log row and value is corresponded to the selected value.
        boolean isSpecialStatusForWaterItemPresent = driver.findElement(LOG_ROW_FOR_WATER_ITEM).isDisplayed();
        assertThat(isSpecialStatusForWaterItemPresent).isTrue();

        boolean isSpecialStatusForWindItemPresent = driver.findElement(LOG_ROW_FOR_WIND_ITEM).isDisplayed();
        assertThat(isSpecialStatusForWindItemPresent).isTrue();

        boolean isSpecialStatusForRadioButtonPresent = driver.findElement(LOG_ROW_FOR_RADIO_BUTTON).isDisplayed();
        assertThat(isSpecialStatusForRadioButtonPresent).isTrue();

        boolean isSpecialStatusForDropdownPresent = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.invisibilityOfElementWithText(LOG_ROW_FOR_DROPDOWN, "Log row  is displayed"));
        assertThat(isSpecialStatusForDropdownPresent).isTrue();




    }

}
