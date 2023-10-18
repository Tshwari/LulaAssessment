Feature:  Successful purchase of Item

Scenario Outline: Successful purchase of Item
Given user navigates to sauce demo website
When user logs in with correct username and password
Then verify correct homepage is loaded
When a user clicks "<Item>" add to cart button
And user clicks on the cart
And user clicks checkout button
And user fills in checkout information and clicks continue
Then verify payment information has the correct sauceCard
And user clicks finish checkout button
Then validate all checks on confirmation page




Examples:
| Item              |
|Sauce Labs Onesie|
