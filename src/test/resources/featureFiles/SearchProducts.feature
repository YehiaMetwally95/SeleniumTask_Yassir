@regression
Feature: Search For Product
  As a logged in user, i want to search for any product, so that all search results matches that product

  Background:
    Given User Navigates to Home Page

  Scenario Outline: Search for Existing Product
    When User searches for product '<productName>'
    Then All Search Results shall matches this Product

    Examples:
      | productName |
      | Sony VAIO |

  Scenario Outline: Search for Non-Existing Product
    When User searches for product '<productName>'
    Then Error Message is displayed 'There is no product that matches the search criteria.'

    Examples:
      | productName |
      | yehia |
