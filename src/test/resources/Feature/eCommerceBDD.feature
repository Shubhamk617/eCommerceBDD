#Author: shubham.kumar1@publicissapient.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: test the functionality of an eCommerce Platform

  Background: Launch the Ecommerce Website
    Given ecommerce Website is launched Successfully
    Then wait for pageLoad and verify the application loaded

  @Regression
  Scenario Outline: Registration and Add to Cart
    Given User is on Homepage
    When User clicks on Create an account link
    And Fill in the Details of the page click on Continue
    Then Click on Contact link
    And Type the Enquiry in Enquiry Box
    And Click on Submit and Continue
    When User Click on Samsung Tab Image
    And Click on Review Tab
    And Fill in details for Review with rating <thisRating>
    And Click on Continue
    And Click on add to wishlist
    And Close the success ribbon message on the page.
    And Click on Wishlist link.
    And Click on Pound Sterling
    And Retrieve the value and display Pound value.
    And Click on Euro Sterling
    And Retrieve the value and display Euro value.
    And Click on US Dollar Sterling
    And Retrieve the value and display US Dollar value.
    And Click on Add To Cart icon
    And Close the success message on the page.
    And Click Remove icon on the product in My Wishlist page.
    And Click on continue from wishlist page.
    Then Click on Logout.

    Examples: 
      | thisRating |
      |          5 |

  @Regression
  Scenario: Product Comparison
    Given User is on Homepage
    When User CLicks On Login Link
    And Enter Email Address and Password and click on Login button
    Then Enter the key word in search text box and Hit Enter
    And Select Monitors under Components in the drop down and Check Search in sub categories and click Search
    Then Click on Phones and PDA
    And Sort from the Price high to low on the page
    Then Click on Add to Compare for the first three phones and click on Close button
    And Click on Product Compare
    Then Click on the first phone link on the page
    And Check the fifth feature in the description section of the phone and write into flat file.
    And Click On the Add to cart button from PDP
    Then Click on Shopping Cart displayed on ribbon message
