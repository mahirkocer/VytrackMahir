Feature: Login as different users

    Scenario Outline: login with different user types

      Given the user is on the login page
      When the user logs in as a "<userType>"
      Then the user should be able to login
      And the title contains "Dashboard"

      Examples:
        | userType      |
        | driver        |
        | sales_manager |
        | store_manager |


