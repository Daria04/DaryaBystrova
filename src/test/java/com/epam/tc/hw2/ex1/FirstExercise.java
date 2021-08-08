package com.epam.tc.hw2.ex1;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FirstExercise extends TestService {

    @Test
    public void exerciseOne() {

        SoftAssertions softly = new SoftAssertions();

        //1. Open test site by URL
        driver.navigate().to(URL);

        //2. Assert Browser title
        String actualTitle = driver.getTitle();
        softly.assertThat(actualTitle).isEqualTo(EXPECTED_TITLE);

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

        //4. Assert Username is logged in
        String actualData = driver.findElement(USER_NAME).getText();
        softly.assertThat(actualData).isEqualTo(EXPECTED_DATA);

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        String actualHomeData = driver.findElement(HOME_BUTTON).getText();
        softly.assertThat(actualHomeData).isEqualTo(EXPECTED_HOME_DATA);

        boolean isHomeImagePresent = driver.findElement(HOME_BUTTON).isDisplayed();
        softly.assertThat(isHomeImagePresent).isTrue();

        String actualContactFormData = driver.findElement(CONTACT_FORM_BUTTON).getText();
        softly.assertThat(actualContactFormData).isEqualTo(EXPECTED_CONTACT_FORM_DATA);

        boolean isContactFormImagePresent = driver.findElement(HOME_BUTTON).isDisplayed();
        softly.assertThat(isContactFormImagePresent).isTrue();

        String actualServiceData = driver.findElement(SERVICE_BUTTON).getText();
        softly.assertThat(actualServiceData).isEqualTo(EXPECTED_SERVICE_DATA);

        boolean isServiceImagePresent = driver.findElement(SERVICE_BUTTON).isDisplayed();
        softly.assertThat(isServiceImagePresent).isTrue();

        String actualMetalsAndColorsData = driver.findElement(METALS_AND_COLORS_BUTTON).getText();
        softly.assertThat(actualMetalsAndColorsData).isEqualTo(EXPECTED_METALS_AND_COLORS_DATA);

        boolean isMetalsAndColorsImagePresent = driver.findElement(METALS_AND_COLORS_BUTTON).isDisplayed();
        softly.assertThat(isMetalsAndColorsImagePresent).isTrue();

        //6. Assert that there are 4 images on the Index Page and they are displayed
        WebElement firstImage = driver.findElement(FIRST_ICON);
        boolean firstImagePresent = firstImage.isDisplayed();
        softly.assertThat(firstImagePresent).isTrue();

        boolean isSecondImagePresent = driver.findElement(SECOND_ICON).isDisplayed();
        softly.assertThat(isSecondImagePresent).isTrue();

        boolean isThirdImagePresent = driver.findElement(THIRD_ICON).isDisplayed();
        softly.assertThat(isThirdImagePresent).isTrue();

        boolean fourthImagePresent = driver.findElement(FOURTH_ICON).isDisplayed();
        softly.assertThat(fourthImagePresent).isTrue();

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        String actualTextUnderFirstImage = driver.findElement(TEXT_UNDER_FIRST_IMAGE).getText();
        softly.assertThat(actualTextUnderFirstImage).isEqualTo(EXPECTED_TEXT_UNDER_FIRST_IMAGE);

        String actualTextUnderSecondImage = driver.findElement(TEXT_UNDER_SECOND_IMAGE).getText();
        softly.assertThat(actualTextUnderSecondImage).isEqualTo(EXPECTED_TEXT_UNDER_SECOND_IMAGE);

        String actualTextUnderThirdImage = driver.findElement(TEXT_UNDER_THIRD_IMAGE).getText();
        softly.assertThat(actualTextUnderThirdImage).isEqualTo(EXPECTED_TEXT_UNDER_THIRD_IMAGE);

        String actualTextUnderFourthImage = driver.findElement(TEXT_UNDER_FOURTH_IMAGE).getText();
        softly.assertThat(actualTextUnderFourthImage).isEqualTo(EXPECTED_TEXT_UNDER_FOURTH_IMAGE);

        //8. Assert that there is the iframe with “Frame Button” exist
        boolean isActualIframeExists = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.invisibilityOfElementWithText(IFRAME, "The iframe exists"));
        softly.assertThat(isActualIframeExists).isTrue();

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        WebElement iframeElement = driver.findElement(IFRAME);
        driver.switchTo().frame(iframeElement);

        boolean isFrameButtonElementPresent = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions
                        .invisibilityOfElementWithText(FRAME_BUTTON, "The 'Frame Button' exists"));
        softly.assertThat(isFrameButtonElementPresent).isTrue();

        //10. Switch to original window back
        driver.switchTo().defaultContent();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        boolean isHomeItemDisplayed = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.invisibilityOfElementWithText(HOME_ITEM, "Home item exists"));
        softly.assertThat(isHomeItemDisplayed).isTrue();

        boolean isContactFormItemDisplayed = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.invisibilityOfElementWithText(CONTACT_FORM_ITEM, "Home item exists"));
        softly.assertThat(isContactFormItemDisplayed).isTrue();

        boolean isServiceItemDisplayed = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.invisibilityOfElementWithText(SERVICE_ITEM, "Home item exists"));
        softly.assertThat(isServiceItemDisplayed).isTrue();

        boolean isMetalsAndColorsItemDisplayed = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.invisibilityOfElementWithText(METALS_AND_COLORS_ITEM, "Home item exists"));
        softly.assertThat(isMetalsAndColorsItemDisplayed).isTrue();

        boolean isElementsPacksItemDisplayed = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.invisibilityOfElementWithText(ELEMENTS_PACKS_ITEM, "Home item exists"));
        softly.assertThat(isElementsPacksItemDisplayed).isTrue();

        softly.assertAll();

    }

}
