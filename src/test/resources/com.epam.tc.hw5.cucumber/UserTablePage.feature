Feature: As a user i want to get ability to see various options on User Table Page

  Scenario: User Table Page test
    Given I open JDI GitHub site
    And I login as user with login 'Roman' and password 'Jdi1234'
    When I click on Service button in header
    And I click on User Table button in Service dropdown
    Then User Table page should be opened
    And 6 Number Type Dropdowns should be displayed on Users Table on User Table Page
    And 6 User names should be displayed on Users Table on User Table Page
    And 6 Description texts under images should be displayed on Users Table on User Table Page
    And 6 checkboxes should be displayed on Users Table on User Table Page
    And User table should contain following values:
    | Number | User             | Description                      |
    | 1      | Roman            | Wolverine                        |
    | 2      | Sergey Ivan      | Spider Man                       |
    | 3      | Vladzimir        | Punisher                         |
    | 4      | Helen Bennett    | Captain America some description |
    | 5      | Yoshi Tannamuri  | Cyclope some description         |
    | 6      | Giovanni Rovelli | Hulk some description            |
    And droplist should contain values in column Type for user Roman
    | Dropdown Values |
    | Admin           |
    | User            |
    | Manager         |







