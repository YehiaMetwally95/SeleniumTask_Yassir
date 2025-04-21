@regression
Feature: Add Product To Cart
  As a logged in user, i want to Add Product to Cart, so that the Product is displayed in Cart Page

  Background:
    Given User Navigates to Products Page

  Scenario Outline: Add Product to Cart
    When User Add Products '<productName1>' '<productName2>' '<productName3>' to Cart
    Then The Product shall be Added in Cart Page

    Examples:
      | productName1 | | productName2 | | productName3 |
      | iPod Nano | | iPod Classic | | HTC Touch HD |
