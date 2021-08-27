package com.epam.tc.hw6.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Verify login with login {Utils.LOGIN} and password {Utils.PASSWORD}")
    public void logInToAccount(String login, String password) {
        headerComponent.clickToSignInButton();
        signInComponent.loginValidUser(login, password);
    }

    @Step("Open Different Elements page")
    public void openDifferentElementsPage() {
        headerComponent.clickToServiceButton();
        serviceComponent.clickToDifferentElementsButton();
    }

    @Step("Select items on Different Elements page")
    public void selectItemsOnDifferentElementsPage() {
        differentElementsPage.selectItemsOnDifferentElementsPage();
    }

    @Step("Switch to iframe")
    public void switchToIframeOnHomePage() {
        homePage.switchToIframe();
    }

    @Step("Switch to original window")
    public void switchToOriginalWindowOnHomePage() {
        homePage.switchToOriginalWindow();
    }
}
