#Author: your.email@your.domain.com
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


Feature: First feature
  I want to use this template for my feature file

  @tag1
  Scenario: Title of your scenario inside Sample1_a
    Given I want to write a step with name as "yash"
    When I complete action
    And some other action
    And yet another action
    Then I validate the outcomes

  @tag2
  Scenario: Successful Login with Valid Credentials inside Sample1_b
    Given User is on Home Page
    When User Navigate to LogIn Page
    And User enters Credentials to LogIn
      | name       | password |
      | testuser_1 | Test@101 |
      | testuser_2 | Test@102 |
   

 @tag3
  Scenario: Title of your scenario inside Sample1_c
    Given I want to write a step with <name> as "yash3"
    When I complete action
    
