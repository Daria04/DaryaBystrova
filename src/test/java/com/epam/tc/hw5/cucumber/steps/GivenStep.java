package com.epam.tc.hw5.cucumber.steps;

import io.cucumber.java.en.Given;

public class GivenStep extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void openGitHubSite() {
        homePage.open();
    }

    @Given("I login as user with login {string} and password {string}")
    public void loginValidUser(String login, String password) {
        var authorization = headerComponent.clickToSignInButton();
        authorization.loginValidUser(login, password);
    }
}
