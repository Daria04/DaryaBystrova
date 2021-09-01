package com.epam.tc.hw7.tests;

import static com.epam.tc.hw7.entities.User.ROMAN;
import static com.epam.tc.hw7.sections.JdiSite.jdiHomePage;
import static com.epam.tc.hw7.sections.JdiSite.jdiMetalAndColorsPage;

import com.epam.tc.hw7.TestsInit;
import com.epam.tc.hw7.entities.MetalAndColors;
import com.epam.tc.hw7.sections.JdiSite;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JdiTest implements TestsInit {

    @Test(dataProvider = "parseFromJson", dataProviderClass = ParseWithDataProvider.class)
    public void metalAndColorsTest(MetalAndColors metalAndColors) {
        JdiSite.openHomePage();
        JdiSite.login(ROMAN);
        jdiHomePage.userName.is().text(ROMAN.getFullName());
        JdiSite.openMetalAndColorsPage();
        JdiSite.jdiMetalAndColorsPage.fillMainForm(metalAndColors);
        Assert.assertEquals(JdiSite.jdiMetalAndColorsPage.getResult(), metalAndColors.toString());
        jdiMetalAndColorsPage.logout();
    }
}
