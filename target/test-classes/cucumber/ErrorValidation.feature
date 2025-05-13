
@tag
Feature: Error Validation
  I want to use this template for my feature file


  @CuRegression
  Scenario Outline: Negative login test
    Given I landed on Ecommerce Page
    When I logged in with username <username> and password <password>
    Then "Incorrect email or password." message is displayed 

 Examples: 
      |username                            |password             |
      |wrongsofhar@gmail.com               |Qwer123$$            |
