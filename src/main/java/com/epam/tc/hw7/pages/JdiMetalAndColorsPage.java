package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.tc.hw7.entities.MetalAndColors;
import com.epam.tc.hw7.forms.MetalAndColorsForm;

public class JdiMetalAndColorsPage extends WebPage {

    @UI(".results") private UIElement result;

    @UI("#user-name") private Button userNameButton;

    @UI(".logout") private Button logoutButton;

    private MetalAndColorsForm metalAndColorsForm;

    public void fillMainForm(MetalAndColors metalAndColors) {
        metalAndColorsForm.fillMainContentForm(metalAndColors);
    }

    public String getResult() {
        return result.getText();
    }

    public void logout() {
        userNameButton.click();
        logoutButton.click();
    }
}
