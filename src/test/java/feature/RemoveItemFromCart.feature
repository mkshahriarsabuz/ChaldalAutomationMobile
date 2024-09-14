Feature: Remove item from cart

  Scenario: Verify Text “Nothing to see here” on cart screen after removing items
    Given Search item "Toothbrush"
    And Scroll down to an item and Open the Item screen
    And Click the Plus + icon 3 times to add to the cart
    And Go to the cart screen from the top
    When Click the Minus - icon to empty the cart
    Then Verify Text "Nothing to see here" on cart screen after removing items