package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestService {

    protected WebDriverWait webDriverWait;
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, 5);
    }

    //12. Close Browser
    @AfterMethod
    public void closeBrowser() {

        webDriverWait = null;
        driver.quit();
    }

    protected static final By SIGN_IN_BUTTON = By.xpath("//div[@class='profile-photo']/following-sibling::span");
    protected static final By ENTER_BUTTON = By.xpath("//span[text()='Enter']");
    protected static final By LOGIN_INPUT_BUTTON = By.id("name");
    protected static final By PASSWORD_INPUT_BUTTON = By.id("password");
    protected static final By USER_NAME = By.id("user-name");
    protected static final By LOCATOR_FOR_ITEMS_ON_THE_HEADER_SECTION = By.cssSelector("ul.nav > li");
    protected static final By SERVICE_BUTTON = By.className("dropdown-toggle");
    protected static final By ALL_IMAGES_ON_THE_INDEX_PAGE = By.className("benefit-icon");
    protected static final By TEXT_UNDER_ALL_IMAGES = By.className("benefit-txt");
    protected static final By IFRAME = By.id("frame");
    protected static final By FRAME_BUTTON = By.id("frame-button");
    protected static final By LOCATOR_FOR_ITEMS_IN_THE_LEFT_SECTION = By.cssSelector("ul.left > li");
    protected static final By DIFFERENT_ELEMENTS_BUTTON = By.xpath("//a[@href='different-elements.html']");
    protected static final By WATER_ITEM_CHECK_BOX = By.xpath("//input[@type='checkbox']");
    protected static final By WIND_ITEM_CHECK_BOX =
            By.xpath("//label[@class='label-checkbox']/following-sibling::label/following-sibling::label");
    protected static final By SELEN_ITEM_CHECK_BOX =
            By.xpath("//div[@class='checkbox-row']//label[@class='label-radio'][4]");
    protected static final By COLOR_INPUT_BUTTON = By.cssSelector("select.uui-form-element");
    protected static final By LOCATOR_FOR_LOG_ROW = By.cssSelector("ul.logs > li");

    protected static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected static final String EXPECTED_TITLE = "Home Page";
    protected static final String LOGIN_DATA = "Roman";
    protected static final String PASSWORD_DATA = "Jdi1234";
    protected static final String EXPECTED_DATA = "ROMAN IOVLEV";
    protected static final List<String> EXPECTED_ITEMS_ON_THE_HEADER_SECTION =
            List.of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    protected static final List<String> ALL_EXPECTED_TEXT_UNDER_IMAGES =
            List.of("To include good practices\n" + "and ideas from successful\n" + "EPAM project",
                    "To be flexible and\n" + "customizable", "To be multiplatform", "Already have good base\n"
                            + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");
    protected static final List<String> EXPECTED_ITEMS_IN_THE_LEFT_SECTION =
            List.of("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");

}
