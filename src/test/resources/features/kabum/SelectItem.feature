Feature: Add item to shopping cart

  As a user
  I want to add a product to the shopping cart
  So that I can proceed to checkout on Kabum's store

  Scenario: Successfully add a product to the cart
    Given I am on the Kabum homepage
    And I search for "mechanical keyboard"
    When I select the first product from the results
    And I click on the "Buy" button
    Then the product should be added to the shopping cart
    And I should see the shopping cart icon updated