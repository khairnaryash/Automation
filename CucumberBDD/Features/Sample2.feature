
@test
Feature: Second Feature
  I want to use this template for my feature file

  @tag1
  Scenario: Successful Login with Valid Credentials inside Sample2_a
    Given User is on Home Page
    When User Navigate to LogIn Page
    And User enters Credentials to LogIn
      | name       | password |
      | testuser_1 | tag1 |
      | testuser_2 | Test@102 |
    
    
    @tag2
  Scenario: Successful Login with Valid Credentials inside Sample2_b
    Given User is on Home Page
    When User Navigate to LogIn Page
    And User enters Credentials to LogIn
      | name       | password |
      | testuser_1 | tag2 |
      | testuser_2 | Test@102 |
    Then Message displayed Login Successfully
    
    @tag3
  Scenario: Successful Login with Valid Credentials inside Sample2_c
    Given User is on Home Page
    When User Navigate to LogIn Page
    And User enters Credentials to LogIn
      | name       | password |
      | testuser_1 | tag3 |
      | testuser_2 | Test@102 |
  
  