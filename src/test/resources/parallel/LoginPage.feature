Feature: Login Page Feture

  Scenario: Login page Title
    Given user is on the login page
    When user gets the title of the page
    Then page title should be "Login - My Store"

  Scenario: Forgot Password Link
    Given user is on the login page
    Then forgot your password link should be displayed

  Scenario: Login with correct credentials
    Given user is on the login page
    When user enters username "rockstarpalash@gmail.com"
    And user enters password "#Abcd123"
    And user clicks on login button
    Then user gets the title of the page
    And page title should be "My account - My Store"
