Feature: Account types
  @smoke
  Scenario: Driver user
    Given the user is on the login page
    Given the user logs in as a "driver"
    When the user navigates to "Activities" "Calendar Events"
    Then the title contains "Calendar Events - Activities"

  Scenario: Sales manager user
    Given the user is on the login page
    Given the user logs in as a "sales_manager"
    When the user navigates to "Customers" "Contacts"
    And user clicks the "cherrylarmstrong@yahoo.com" from contacts
    Then information should be same with database
