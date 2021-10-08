Feature: Account Page Feature

  Background: 
    Given user has already logged in to the application
      | username                 | password |
      | rockstarpalash@gmail.com | #Abcd123 |

  Scenario: Account page title
    Given user is on Account Page
    When user gets the title of the page
    Then page title should be "My account - My Store"

  Scenario: Account section count
    Given user is on Account Page
    Then user gets accounts section
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
      | MY WISHLISTS              |
    And account section count should be 5
