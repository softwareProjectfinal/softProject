
Feature: Sign in
  I want to use this template for my feature file

  Scenario: Log in with valid credentials
    Given I am on the login page
    When I enter username and password 
    And I click the Enter button
    When I been a client
    Then I should be redirected to the client Menu
    When I been an admin
    Then I should be redirected to the Admin Menu


    Scenario: log in with invalid credentials
    Given I am on the login page
    When I enter username and password
    And I click the Enter button
    Then I should see an error message "Invalid username or password"
    And I should remain on the login page



  Scenario: User can choose to stay logged in
    Given I am on the login page
    When I enter valid credentials
    And I check the "Remember Me" checkbox
    And I click the "Login" button
    Then I should be redirected to the home page
    And I should be automatically logged in on my next visit

