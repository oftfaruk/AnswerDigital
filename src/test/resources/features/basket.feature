Feature: Basket

  Scenario: Delete Button
    Given User is on the  "Main Page"
    Given User buys 1 item from "Dresses" "Summer Dresses"
    When  User goes Shopping Cart Page
    Then  "Delete" button is displayed


  Scenario: Delete Basket İtems
    Given User has 1 item in the Basket
    When  User deletes the item from the Basket
    Then  User should be able to see "Your shopping cart is empty." message

  @wip
  Scenario: Delete  All Basket İtems
    Given User has 5 item in the Basket
    When  User deletes the item from the Basket
    Then  User should be able to see "Your shopping cart is empty." message
    


