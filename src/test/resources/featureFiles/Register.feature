Feature: User Registration
  In order to open User Dashboard, As user i want to register with new user account

  Background:
    Given User navigates to Registration Page

  Scenario Outline: Valid Registration with Input Data
    When User updates his personal data '<firstName>' '<lastName>' '<email>' '<mobileNumber>' '<password>'
    Then Success Message 'Your Account Has Been Created!' is displayed
    And User is redirected to Dashboard Page

    Examples:
      | firstName | lastName | email | | mobileNumber | | password |
      | Yehia | Metwally | yehia19@gmail.com | | 01234567234 | | strongPassword |

  @regression
  Scenario: Valid Registration with Random Data
    When User updates random personal data and Submit
    Then Success Message 'Your Account Has Been Created!' is displayed
    And User is redirected to Dashboard Page