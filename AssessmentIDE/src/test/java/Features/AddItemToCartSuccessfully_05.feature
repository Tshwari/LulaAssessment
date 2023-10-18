Feature: Successful  Login And Add Item To Cart

  Scenario: Successful  Login And Add Item To Cart
    Given user navigates to sauce demo website
    When user logs in with correct username and password
    And user selects the product storing icon  and select Price (low to high)
    And a user clicks "<Item>" add to cart button
    Then user confirm that the notification badge displays on the shopping cart icon
    And user click the hamburger bar
    Then user logs out