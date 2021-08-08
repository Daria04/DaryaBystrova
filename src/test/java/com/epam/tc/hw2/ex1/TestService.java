package com.epam.tc.hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestService {

    protected WebDriver driver;

    protected static final By SIGN_IN_BUTTON = By.xpath("//div[@class='profile-photo']/following-sibling::span");
    protected static final By ENTER_BUTTON = By.xpath("//span[text()='Enter']");
    protected static final By LOGIN_INPUT_BUTTON = By.id("name");
    protected static final By PASSWORD_INPUT_BUTTON = By.id("password");
    protected static final By USER_NAME = By.id("user-name");
    protected static final By HOME_BUTTON = By.xpath("//a[text()='Home']");
    protected static final By CONTACT_FORM_BUTTON = By.xpath("//a[text()='Contact form']");
    protected static final By SERVICE_BUTTON = By.className("dropdown-toggle");
    protected static final By METALS_AND_COLORS_BUTTON = By.cssSelector("a[href='metals-colors.html']");

    protected static final By FIRST_ICON = By.xpath("//span[@class='icons-benefit icon-practise']");
    protected static final By TEXT_UNDER_FIRST_IMAGE = By.xpath("//span[text()='and ideas from successful']");

    protected static final By SECOND_ICON = By.xpath("//span[@class='icons-benefit icon-custom']");
    protected static final By TEXT_UNDER_SECOND_IMAGE = By.xpath("//span[text()='customizable ']");

    protected static final By THIRD_ICON = By.xpath("//span[@class='icons-benefit icon-multi']");
    protected static final By TEXT_UNDER_THIRD_IMAGE = By.xpath("//span[text()='To be multiplatform ']");

    protected static final By FOURTH_ICON = By.xpath("//span[@class='icons-benefit icon-base']");
    protected static final By TEXT_UNDER_FOURTH_IMAGE = By.xpath("//span[text()='Already have good base']");
    protected static final By IFRAME = By.id("frame");
    protected static final By FRAME_BUTTON = By.id("frame-button");
    protected static final By HOME_ITEM = By.xpath("//span[text()='Home']");
    protected static final By CONTACT_FORM_ITEM = By.xpath("//span[text()='Contact form']");
    protected static final By SERVICE_ITEM = By.xpath("//span[text()='Service']");
    protected static final By METALS_AND_COLORS_ITEM = By.xpath("//span[text()='Metals & Colors']");
    protected static final By ELEMENTS_PACKS_ITEM = By.xpath("//span[text()='Elements packs']");

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

    @BeforeMethod
    public void setUpClass() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

    }

    //12. Close Browse
    @AfterMethod
    public void closeBrowser() {

        driver.close();
    }
}
