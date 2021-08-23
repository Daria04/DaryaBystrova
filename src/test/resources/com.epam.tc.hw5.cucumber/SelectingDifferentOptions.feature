Feature: As a user i want to get ability to select different options

  Scenario: Select options from Different Elements Page
    Given I open JDI GitHub site
    And I login as user with login 'Roman' and password 'Jdi1234'
    When I click on Service button in header
    And I click on Different Elements button in Service dropdown
    And I select items on Different Elements page
    Then individual log row should be displayed for each selected item on Different Elements page
    And each of selected items and its status should be consistent with selected on Different Elements page
