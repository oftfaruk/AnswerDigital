Feature: Summer Dresses

  Scenario: Summer Collection
    When User  hover and selects "Summer Dresses" under "Women" options
    Then User views "Printed Summer Dress" from the Summer Collection

  Scenario: Women Sub navigation options
    Given User is on  "Main" page
    When User  hover on "Women"
    Then Sub navigation options appear
    |T-shirts|
    |Blouses |
    |Casual Dresses|
    |Evening Dresses|
    |Summer Dresses |
