@Regression
Feature: Add product to cart

  Scenario: Add product to cart through Cart link
    Given the user goes to Cart link
    When the user adds product "12123" to cart through Cart Page
    Then the product "12123" is added to cart

  Scenario: Add product to cart through Shop subcategory
    Given the user goes to Shop subcategory
    When the user adds product "12123" to cart through Shop page
    Then the product "12123" is added to cart