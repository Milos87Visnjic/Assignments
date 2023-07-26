Feature: Verify PlayerAccount and PlayerProfile Name

  @verifyPlayerAccount
  Scenario: Verify PlayerAccount and PlayerProfile Name based on Player Profile Name
    Given User navigates to Game Portal Page
    And User accepts all cookies and age questions
    And User logs in
    When User clicks on Avatar or user's credentials
    And User clicks on Player Account Tab
    Then User's name on the Player Account should be correct
    And User clicks on Player's Profile
    And The user's name and the name in Player Profile should be equal

  @verifyCheckboxes
  Scenario: Ability to verify checkboxes Edit Communication
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    When User logs in with valid credentials
    Then the user views that avatar is visible
    And User clicks on avatar
    And User clicks on Player Account button
    And User clicks on settings button
    And User clicks on edit comm button
    When User selects checkboxes of EditComm
    Then User verifies all checkboxes are clicked

  @shadow
  Scenario: Ability to open Contact Us and submit the request
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    When User logs in with valid credentials
    Then the user views that avatar is visible
    And User gets feedBack

  @contactUs
  Scenario: Ability to open Contact Us and submit the request
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    When User logs in with valid credentials
    Then the user views that avatar is visible
    And User clicks on feedBack button
    And User gets feedBack
    And User requests support