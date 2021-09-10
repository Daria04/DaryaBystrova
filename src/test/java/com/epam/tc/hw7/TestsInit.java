package com.epam.tc.hw7;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.driver.get.DriverInfos.CHROME_INFO;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.light.settings.WebSettings.useDriver;

import com.epam.tc.hw7.sections.JdiSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public interface TestsInit {

    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        useDriver(CHROME_INFO::getDriver);
        initSite(JdiSite.class);
        logger.info("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    static void teardown() {
        killAllSeleniumDrivers();
    }
}
