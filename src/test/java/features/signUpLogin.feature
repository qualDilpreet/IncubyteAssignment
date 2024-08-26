Feature: Sign Up and Login

  Scenario: Sign up for a new account and login
    Given I am on the home page
    When I sign up with random details
    Then I should be able to login with the same credentials