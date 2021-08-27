package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.cucumber.context.TestContext;
import com.epam.tc.hw5.page.DifferentElementsPage;
import com.epam.tc.hw5.page.HomePage;
import com.epam.tc.hw5.page.UserTablePage;
import com.epam.tc.hw5.page.component.HeaderComponent;
import com.epam.tc.hw5.page.component.ServiceComponent;
import com.epam.tc.hw5.page.component.SignInComponent;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    WebDriver driver = TestContext.getInstance().getTestObject("web_driver");

    protected HomePage homePage;
    protected SignInComponent signInComponent;
    protected HeaderComponent headerComponent;
    protected ServiceComponent serviceComponent;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;

    public AbstractStep() {
        homePage = new HomePage(driver);
        headerComponent = new HeaderComponent(driver);
        signInComponent = new SignInComponent(driver);
        serviceComponent = new ServiceComponent(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        userTablePage = new UserTablePage(driver);

    }
}
