package com.epam.tc.hw5.cucumber.steps;

import io.cucumber.java.en.When;

public class ActionStep extends AbstractStep {

    @When("I click on Service button in header")
    public void clickOnServiceButtonInHeader() {
        headerComponent.clickToServiceButton();
    }

    @When("I click on Different Elements button in Service dropdown")
    public void clickOnDifferentElementsButtonOnServiceComponent() {
        serviceComponent.clickToDifferentElementsButton();
    }

    @When("I select items on Different Elements page")
    public void selectVariousItemsOnDifferentElementsPage() {
        differentElementsPage.selectItemsOnDifferentElementsPage();
    }

    @When("I click on User Table button in Service dropdown")
    public void clickOnUserTableButtonInServiceDropdown() {
        serviceComponent.clickToUserTableButton();
    }

    @When("I select Vip checkbox for Sergey Ivan")
    public void selectCheckboxForUser() {
        userTablePage.selectVipCheckboxForUser();
    }
}
