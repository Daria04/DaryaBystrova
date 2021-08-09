package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Arrays;
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
    protected static final By HOME_BUTTON = By.xpath("//a[text()='Home']");
    protected static final By CONTACT_FORM_BUTTON = By.xpath("//a[text()='Contact form']");
    protected static final By SERVICE_BUTTON = By.className("dropdown-toggle");
    protected static final By METALS_AND_COLORS_BUTTON = By.cssSelector("a[href='metals-colors.html']");
    protected static final By ALL_IMAGES_ON_THE_INDEX_PAGE = By.className("benefit-icon");
    protected static final By TEXT_UNDER_ALL_IMAGES = By.className("benefit-txt");
    protected static final By IFRAME = By.id("frame");
    protected static final By FRAME_BUTTON = By.id("frame-button");
    protected static final By HOME_ITEM = By.xpath("//span[text()='Home']");
    protected static final By CONTACT_FORM_ITEM = By.xpath("//span[text()='Contact form']");
    protected static final By SERVICE_ITEM = By.xpath("//span[text()='Service']");
    protected static final By METALS_AND_COLORS_ITEM = By.xpath("//span[text()='Metals & Colors']");
    protected static final By ELEMENTS_PACKS_ITEM = By.xpath("//span[text()='Elements packs']");
    protected static final By DIFFERENT_ELEMENTS_BUTTON = By.xpath("//a[@href='different-elements.html']");
    protected static final By WATER_ITEM_CHECK_BOX = By.xpath("//input[@type='checkbox']");
    protected static final By WIND_ITEM_CHECK_BOX =
            By.xpath("//label[@class='label-checkbox']/following-sibling::label/following-sibling::label");
    protected static final By SELEN_ITEM_CHECK_BOX =
            By.xpath("//div[@class='checkbox-row']//label[@class='label-radio'][4]");
    protected static final By COLOR_INPUT_BUTTON = By.cssSelector("select.uui-form-element");
    protected static final By LOG_ROW_FOR_WATER_ITEM = By.xpath("//li[contains(text(),'Water: condition')]");
    protected static final By LOG_ROW_FOR_WIND_ITEM = By.xpath("//li[contains(text(),'Wind: condition')]");
    protected static final By LOG_ROW_FOR_RADIO_BUTTON = By.xpath("//li[contains(text(),'metal: value')]");
    protected static final By LOG_ROW_FOR_DROPDOWN = By.partialLinkText("changed to Yellow");

    protected static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected static final String EXPECTED_TITLE = "Home Page";
    protected static final String LOGIN_DATA = "Roman";
    protected static final String PASSWORD_DATA = "Jdi1234";
    protected static final String EXPECTED_DATA = "ROMAN IOVLEV";
    protected static final String EXPECTED_HOME_DATA = "HOME";
    protected static final String EXPECTED_CONTACT_FORM_DATA = "CONTACT FORM";
    protected static final String EXPECTED_SERVICE_DATA = "SERVICE";
    protected static final String EXPECTED_METALS_AND_COLORS_DATA = "METALS & COLORS";
    protected static final String EXPECTED_TEXT_UNDER_FIRST_IMAGE = "To include good practices\n"
            + "and ideas from successful\n" + "EPAM project";
    protected static final String EXPECTED_TEXT_UNDER_SECOND_IMAGE = "To be flexible and\n" + "customizable";
    protected static final String EXPECTED_TEXT_UNDER_THIRD_IMAGE = "To be multiplatform";
    protected static final String EXPECTED_TEXT_UNDER_FOURTH_IMAGE = "Already have good base\n"
            + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…";
    protected static final String EXPECTED_HOME_ITEM = "Home";
    protected static final String EXPECTED_CONTACT_FORM_ITEM = "Contact form";
    protected static final String EXPECTED_SERVICE_ITEM = "Service";
    protected static final String EXPECTED_METALS_AND_COLORS_ITEM = "Metals & Colors";
    protected static final String EXPECTED_ELEMENTS_PACKS_ITEM = "Elements packs";

    public List<String> expectedData() {

        return Arrays.asList(URL, EXPECTED_TITLE, LOGIN_DATA, PASSWORD_DATA, EXPECTED_DATA, EXPECTED_HOME_DATA,
                EXPECTED_CONTACT_FORM_DATA, EXPECTED_SERVICE_DATA, EXPECTED_METALS_AND_COLORS_DATA,
                EXPECTED_TEXT_UNDER_FIRST_IMAGE, EXPECTED_TEXT_UNDER_SECOND_IMAGE,
                EXPECTED_TEXT_UNDER_THIRD_IMAGE, EXPECTED_TEXT_UNDER_FOURTH_IMAGE, EXPECTED_HOME_ITEM,
                EXPECTED_CONTACT_FORM_ITEM, EXPECTED_SERVICE_ITEM, EXPECTED_METALS_AND_COLORS_ITEM,
                EXPECTED_ELEMENTS_PACKS_ITEM);
    }

}
