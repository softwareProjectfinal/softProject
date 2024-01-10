
Feature: Sign Up
  Sign up should be quick and friendly

  Scenario: successful sign-up
  	
  	new users should get a confirmation email and be 
  	greeted personally by the site once signed in.
  	
    Given I have chosen to sign up
    When i sign up with valid details
    Then i should recive a confirmation email
    And i should see a personalized greeting message

  Scenario: Existing Email
    Given A user with email already exists
    When I enter the same email address on the sign-up page
    And I click the Enter button
    Then I should see an error message "Email address is already in use"
    
    
  Scenario Outline: invalid information
    Given I am on the sign-up page
    When I enter <invalid_input> in the <field> field
    And I click the Enter button
    Then I should see an error message "<error_message>"

    Examples:
      | invalid_input | field         | error_message                             |
      | ""            | Email address | Please enter a valid email address       |
      | "user1"       | Password      | Password must be at least 8 characters long |
      | "12345678"    | Password      | Password must contain a mix of letters, numbers, and symbols |
    
    
   Scenario: sign up without entering all required fields
    Given I am on the sign-up page
    When I leave a required field blank
    And I click the Enter button
    Then I should see an error message highlighting the missing field
    
    
    Scenario: User tries to sign up with a weak password
    Given I am on the sign-up page
    When I enter a password that does not meet strength requirements
    And I click the Enter button
    Then I should see an error message "Password must meet strength requirements"
    And I should be provided with password strength guidelines
    