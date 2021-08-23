package com.epam.tc.hw5.page;

import com.epam.tc.hw4.Utils;
import com.epam.tc.hw5.page.component.AbstractComponent;
import com.epam.tc.hw5.page.component.HeaderComponent;
import com.epam.tc.hw5.page.component.SignInComponent;
import org.openqa.selenium.WebDriver;

public class AbstractBasePage extends AbstractComponent {

    protected HeaderComponent header;

    protected AbstractBasePage(WebDriver driver) {
        super(driver);
        header = new HeaderComponent(driver);
    }

    public SignInComponent clickToSignInButton() {
        return header.clickToSignInButton();
    }

    protected void open(String url) {
        driver.navigate().to(Utils.URL + url);
    }
}
