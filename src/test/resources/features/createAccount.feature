Feature: Create User Accunt

  Scenario: Create Account
    When User creates a new account
    Then User goes to "MY ACCOUNT" page

  Scenario: User Buys İtem
    Given User login with "theodore.ankunding@yahoo.com" email adress
    Then  User buys 1 item from "Dresses" "Summer Dresses"
    And   User views  "Jolanda Wilkinson" name in the Your Shopping Cart Page
    And   User views "Your shopping cart contains: 1 Product" in the Your Shopping Cart Page

    Scenario: Create Accoount With Missing parts
      Given User is on "Create Account Page"
      When User tries to create account without filling all boxes
      Then User takes "Error" message