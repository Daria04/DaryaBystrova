package com.epam.tc.hw6.steps;

import com.epam.tc.hw6.page.DifferentElementsPage;
import com.epam.tc.hw6.page.HomePage;
import com.epam.tc.hw6.page.component.HeaderComponent;
import com.epam.tc.hw6.page.component.ServiceComponent;
import com.epam.tc.hw6.page.component.SignInComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected SignInComponent signInComponent;
    protected ServiceComponent serviceComponent;
    protected HeaderComponent headerComponent;

    protected AbstractStep(WebDriver driver) {
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        signInComponent = new SignInComponent(driver);
        serviceComponent = new ServiceComponent(driver);
        headerComponent = new HeaderComponent(driver);
    }

    @Step("Open home page JDI GitHub")
    public void openHomePage() {
        homePage.open();
    }
}
