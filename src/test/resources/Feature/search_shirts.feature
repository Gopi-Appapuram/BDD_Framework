Feature: Myntra Application Testing

  Scenario: Search for a Product
    Given I am on the Academy website
    When I search for "Sheos" in the search textbox
    Then I can see list of product list page

  Scenario: Filter Products by Price Range
    Given I can see list of products
    When I applied any filter for price range
    Then I can see only products within the specified price range
    And I select a product with any index from the list

  Scenario: Get Product Name and Price
    Given I am on the product details page
    Then I should see the product name and price

  Scenario: Add Product to Cart
    Given I selected a product variant from the list
    When I add the item to the cart
    And I am on cart page
    Then I can see the item in the cart

  Scenario: Remove Product from Cart
    Given I can see the item in the cart
    When User removes the items from the cart
    Then User should see an empty cart
    And Close the browser