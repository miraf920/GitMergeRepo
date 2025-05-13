
@tag
Feature: Purchase the order from ecommere website
  I want to use this template for my feature file

 Background:
Given I landed on Ecommerce Page

  @tag2
  Scenario Outline: Positive Test for purchasing order
    Given I logged in with username <username> and password <password>
    When I add the product <productName> to Cart
    And Checkout product <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      |username                       |password             |productName                |
      |sofhar@gmail.com               |Qwer123$$            |ZARA COAT 3,ADIDAS ORIGINAL|
