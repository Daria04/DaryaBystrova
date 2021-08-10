package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.TestService;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

        WebElement login = webDriverWait
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
        List<WebElement> allActualData = driver.findElements(LOCATOR_FOR_ITEMS_ON_THE_HEADER_SECTION);

        for (WebElement actualItem : allActualData) {
            softly.assertThat(actualItem.isDisplayed());
        }

        List<String> allActualDataForMenuButtons = new ArrayList<>();
        allActualData
                .stream()
                .map(WebElement::getText)
                .forEach(allActualDataForMenuButtons::add);

        softly.assertThat(allActualDataForMenuButtons).isEqualTo(EXPECTED_ITEMS_ON_THE_HEADER_SECTION);

        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> allImages = driver.findElements(ALL_IMAGES_ON_THE_INDEX_PAGE);

        for (WebElement image : allImages) {
            softly.assertThat(image.isDisplayed());
        }

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> allActualText = new ArrayList<>();
        driver.findElements(TEXT_UNDER_ALL_IMAGES)
                .stream()
                .map(WebElement::getText)
                .forEach(allActualText::add);

        softly.assertThat(allActualText).isEqualTo(ALL_EXPECTED_TEXT_UNDER_IMAGES);

        //8. Assert that there is the iframe with “Frame Button” exist
        boolean isActualIframeExists = webDriverWait
                .until(ExpectedConditions.invisibilityOfElementWithText(IFRAME, "The iframe exists"));
        softly.assertThat(isActualIframeExists);

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        WebElement iframeElement = driver.findElement(IFRAME);
        driver.switchTo().frame(iframeElement);

        boolean isFrameButtonElementPresent = webDriverWait.until(ExpectedConditions
                        .invisibilityOfElementWithText(FRAME_BUTTON, "The 'Frame Button' exists"));
        softly.assertThat(isFrameButtonElementPresent);

        //10. Switch to original window back
        driver.switchTo().defaultContent();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> allActualItems = driver.findElements(LOCATOR_FOR_ITEMS_IN_THE_LEFT_SECTION);

        for (WebElement actualItem : allActualItems) {
            softly.assertThat(actualItem.isDisplayed());
        }

        List<String> allActualItemsInTheLeftSection = new ArrayList<>();
        allActualItems.stream()
                .map(WebElement::getText)
                .forEach(allActualItemsInTheLeftSection::add);

        softly.assertThat(allActualItemsInTheLeftSection).isEqualTo(EXPECTED_ITEMS_IN_THE_LEFT_SECTION);

        softly.assertAll();
    }
}
