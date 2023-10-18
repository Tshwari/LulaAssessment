Feature: Check Status Code Of SauceDemo UrL

  Scenario: Verify Status 200 is returned on SauceDemo UrL
    Given a user is given the sauce demo url and sends a Get request
    Then a valid respone is returned
