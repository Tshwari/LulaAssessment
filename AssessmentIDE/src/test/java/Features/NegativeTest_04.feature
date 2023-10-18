Feature: Confirm Error Message And Click Close Icon

  Scenario: Login with invalid credentials and confirm error message and click close icon
    Given user navigates to sauce demo website
    When user enters incorrect username and password
    Then error message is displayed
    And user clicks on the X icon on the error message to make it disappear
