Feature: Users should be able to login

  @login
  Scenario: Authenticated users should be able to login
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    When User logs in with valid credentials
    Then the user views that avatar is visible


