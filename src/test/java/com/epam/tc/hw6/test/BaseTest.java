package com.epam.tc.hw6.test;

import com.epam.tc.hw6.driver.WebDriverSingleton;
import com.epam.tc.hw6.steps.ActionStep;
import com.epam.tc.hw6.steps.AssertionStep;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    ActionStep actionStep;
    AssertionStep assertionStep;

    @BeforeMethod()
    public void setUp(ITestContext context) {
        var driver = WebDriverSingleton.getDriver();

        driver.manage().window().maximize();
        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);
        context.setAttribute("driver", driver);
    }

    @AfterMethod()
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }
}
