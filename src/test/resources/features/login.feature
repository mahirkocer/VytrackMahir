@login @smoke
Feature: Users should be able to login

  Background:
    Given the user is on the login page

  @driver
  Scenario: Login as a driver
    When the user enters the driver information
    Then the user should be able to login
    And the title contains "Dashboard"
  @sales_manager
  Scenario:  Login as a sales manager
    When the user enters the sales manager information
    Then the user should be able to login
    And the title contains "Dashboard"
  @store_manager
  Scenario: Login as a store manager
    When the user enters the store manager information
    Then the user should be able to login
    And the title contains "Dashboard"


