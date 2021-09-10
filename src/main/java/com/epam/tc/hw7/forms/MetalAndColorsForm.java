package com.epam.tc.hw7.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.entities.MetalAndColors;

public class MetalAndColorsForm extends Form<MetalAndColors> {

    @UI("[name='custom_radio_odd']") private RadioButtons oddRadioButtons;

    @UI("[name='custom_radio_even']") private RadioButtons evenRadioButtons;

    @UI(".vertical-group .uui-form-element") private Checklist listOfElements;

    @JDropdown(root = ".colors",
            value = ".selectpicker",
            list = "li",
            expand = ".caret")
    private Dropdown colorsDropdown;

    @JDropdown(root = ".salad .salad",
            value = ".dropdown-menu",
            list = ".salad li",
            expand = ".caret")
    private Dropdown vegetablesDropdown;

    @JDropdown(root = ".metals",
            value = ".selectpicker",
            list = "li",
            expand = ".caret")
    private Dropdown metalsDropdown;

    @UI("#g7") private Checkbox vegetablesCheckbox;

    @UI("#submit-button") private Button submitButton;

    @Override
    public void submit(MetalAndColors metalAndColors) {
        oddRadioButtons.select(metalAndColors.getSummary().get(0).toString());
        evenRadioButtons.select(metalAndColors.getSummary().get(1).toString());

        metalAndColors.getElements().forEach(listOfElements::select);

        colorsDropdown.select(metalAndColors.getColor());
        metalsDropdown.select(metalAndColors.getMetals());

        metalAndColors.getVegetables().forEach(vegetablesDropdown::select);

        vegetablesCheckbox.click();
        submitButton.click();
    }
}
