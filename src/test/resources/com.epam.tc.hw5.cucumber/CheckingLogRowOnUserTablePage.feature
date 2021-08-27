Feature: As user i want to get ability to see an individual log row for each checkbox

  Scenario: Log row should be displayed for selected checkbox
    Given I open JDI GitHub site
    And I login as user with login 'Roman' and password 'Jdi1234'
    And I click on Service button in header
    And I click on User Table button in Service dropdown
    When I select Vip checkbox for Sergey Ivan
    Then 1 log row has "Vip: condition changed to true" text in log section