package com.epam.tc.hw2.ex2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestService {

    public WebDriver driver;

    protected static final By SIGN_IN_BUTTON = By.xpath("//div[@class='profile-photo']/following-sibling::span");
    protected static final By ENTER_BUTTON = By.xpath("//span[text()='Enter']");
    protected static final By LOGIN_INPUT_BUTTON = By.id("name");
    protected static final By PASSWORD_INPUT_BUTTON = By.id("password");
    protected static final By USER_NAME = By.id("user-name");
    protected static final By SERVICE_BUTTON = By.className("dropdown-toggle");
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



    @BeforeMethod
    public void setUpClass() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

    }

    //10. Close Browse
    @AfterMethod
    public void closeBrowser() {

        driver.quit();
    }

}
