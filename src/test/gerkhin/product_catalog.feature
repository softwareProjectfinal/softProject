Feature: Product Catalog

  Scenario: Viewing Products
    Given the product catalog is populated
    When the user requests to view products
    Then the user should see a list of products

  Scenario: Filtering Products by Catalog
    Given the product catalog is populated
    When the user filters products by the "Interior" catalog
    Then the user should see only products in the "Interior" catalog