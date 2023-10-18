Feature: Verify that item can be removed

  Scenario Outline: Verify that item can be removed
    Given user navigates to sauce demo website
    When user logs in with correct username and password
    Then verify correct homepage is loaded
    And verify remove button on "<Item>" is displayed
    When a user clicks on remove button for "<Item>"

    Examples:
     | Item              |
     |Sauce Labs Backpack|





