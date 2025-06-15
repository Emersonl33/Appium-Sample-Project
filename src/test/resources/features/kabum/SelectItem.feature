Feature: Add item to shopping cart

  As a user
  I want to add a product to the shopping cart
  So that I can proceed to checkout on Kabum's store

  Scenario: Successfully add a product to the cart
    Given I am on the Kabum homepage
    And I search for "RTX 5070"
    When I select the product desired from the results
    Then the product should be added to the shopping cart