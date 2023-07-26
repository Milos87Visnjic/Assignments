Feature: Ability for players to view Individual Rankings


  @sum
  Scenario: Ability for players to view individual rankings summary
    Given User navigates to Game Portal Page
    And User accepts all cookies and age questions
    And The user logs in
    And User clicks on the hamburger menu
    When User clicks on Individuals button in dropdown menu
    Then User gets summary of IRS

  @CP-3407
  Scenario: Ability for player to navigate back to Rankings summary
    Given User navigates to Game Portal Page
    And User accepts all cookies and age questions
    And The user logs in
    And User clicks on the hamburger menu
    And User clicks on Individuals button in dropdown menu
      # User clicks on each arrow at the end of the row then clicks on back button,
      # and checks if it is returning to top rankings menu.
    When User clicks on the arrow at the end of each row and verifies back button functioning


  @row
  Scenario: Ability to handle tables in IRS
    Given User navigates to Game Portal Page
    And User accepts all cookies and age questions
    And The user logs in
    And User clicks on the hamburger menu
    When User clicks on Individuals button in dropdown menu
    Then User views row numbers




