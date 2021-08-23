package com.epam.tc.hw5.cucumber.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.Constants;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AssertionStep extends AbstractStep {

    @Then("individual log row should be displayed for each selected item on Different Elements page")
    public void individualLogRowShouldBeDisplayedForEachSelectedItem() {
        assertThat(differentElementsPage.areLogRowsDisplayed()).isTrue();
    }

    @Then("each of selected items and its status should be consistent with selected on Different Elements page")
    public void selectedItemsAndItsStatusShouldBeConsistentWithSelected() {
        assertThat(differentElementsPage.actualLogRows())
                .containsAll(Constants.EXPECTED_LOG_ROWS);
    }

    @Then("User Table page should be opened")
    public void userTablePageShouldBeOpened() {
        String title = driver.getTitle();
        assertThat(title).isEqualTo(Constants.EXPECTED_TITLE);
    }

    @Then("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void sixNumberTypeShouldBeDisplayedOnUserTablePage() {
        assertThat(userTablePage.areNumberTypesDisplayed()).isTrue();
    }

    @Then("6 User names should be displayed on Users Table on User Table Page")
    public void sixUserNamesShouldBeDisplayedOnUserTablePage() {
        assertThat(userTablePage.areUserNamesDisplayed()).isTrue();
    }

    @Then("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void sixDescriptionTextsUnderImagesShouldBeDisplayedOnUserTablePage() {
        assertThat(userTablePage.areDescriptionTextsDisplayed()).isTrue();
    }

    @Then("6 checkboxes should be displayed on Users Table on User Table Page")
    public void sixCheckboxesShouldBeDisplayedOnUserTablePage() {
        assertThat(userTablePage.areCheckboxesDisplayed()).isTrue();
    }

    @Then("User table should contain following values:")
    public void userTableShouldContainValues(DataTable table) {
        List<List<String>> listRows = table.asLists(String.class);
        List<String> numbersExpected = new ArrayList<>();
        List<String> userNamesExpected = new ArrayList<>();
        List<String> descriptionExpected = new ArrayList<>();
        for (int i = 1; i < listRows.size(); i++) {
            numbersExpected.add(listRows.get(i).get(0));
            userNamesExpected.add(listRows.get(i).get(1));
            descriptionExpected.add(listRows.get(i).get(2));
        }
        assertThat(userTablePage.getNumberColumn()).isEqualTo(numbersExpected);
        assertThat(userTablePage.getUserNameColumn()).isEqualTo(userNamesExpected);
        assertThat(userTablePage.getDescriptionColumn()).isEqualTo(descriptionExpected);
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void droplistShouldContainValuesInColumnTypeForUserRoman(DataTable table) {
        List<String> dropdownValuesExpected = table
                .asList()
                .stream()
                .skip(1)
                .collect(Collectors.toList());
        assertThat(dropdownValuesExpected).isEqualTo(userTablePage.getDropdownValuesForUserRoman());
    }

    @Then("1 log row has \"Vip: condition changed to true\" text in log section")
    public void logRowStatusOnUserTablePage() {
        assertThat(userTablePage.logRowShouldBeVisible())
                .isEqualTo(Constants.EXPECTED_LOG_ROW_ON_USER_TABLE_PAGE);
    }
}
