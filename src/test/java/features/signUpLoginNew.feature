Feature: User Registration and Login

  Scenario: Sign up for a new account and login
    Given I am on the registration page
    When I register with the following details:

      | firstName | Random |
      | lastName  | Random |
      | email     | Random |
      | password  | Random |

    Then I should see the confirmation message "Thank you for registering with Main Website Store."
    When I log out
    When I login with the generated details:
      | email          | Random   |
      | password         | Random     |

  Scenario: User logs in with valid credentials
    Given I am on the login page
    When I login with the following details:
      | email               | john.denis123@example.com|
      | password            | Password@123 |
    Then I should see the message "Welcome, john denis!"