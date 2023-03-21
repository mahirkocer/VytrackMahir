Feature: Fleet feature
  @smoke @wip
  Scenario: Verify the vehicles model information with database
    Given the user is on the login page
    Given the user logs in as a "sales_manager"
    When the user navigates to "Fleet" "Vehicles Model"
    Then the title contains "Vehicles Model"
    When the user clicks the " model name"
    Then the "model name" information should be match with database
