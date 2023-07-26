Feature:Ability to handle tables in CP

  @cp
  Scenario: Ability to verify tables Latest Start
    Given User navigates to Game Portal Page
    And User accepts all cookies and age questions
    And User logs in with valid credentials
    And User clicks on the hamburger menu
    When User clicks on Play for Fun Contests button in Hamburger menu
    Then User verifies Play For Fun button is clicked
    And User clicks on Soonest Start selection box
    When User clicks on Latest Start button
    Then User verifies contests number in contests table
    When User clicks on third contest
    Then User verifies game dates

  @acct
  Scenario: Ability to verify tables Most Players
    Given User navigates to Game Portal Page
    And User accepts all cookies and age questions
    And User logs in with valid credentials
    And User clicks on the hamburger menu
    When User clicks on Play for Fun Contests button in Hamburger menu
    Then User verifies Play For Fun button is clicked
    And User clicks on Soonest Start selection box
    When User clicks on Most Players button
    Then User verifies contests number in contests table
    When User clicks on third contest
    Then User verifies game dates

  @leagues
  Scenario: Ability to verify tables Fewest Players
    Given User navigates to Game Portal Page
    And User accepts all cookies and age questions
    And User logs in with valid credentials
    And User clicks on the hamburger menu
    When User clicks on Play for Fun Contests button in Hamburger menu
    Then User verifies Play For Fun button is clicked
    And User clicks on Soonest Start selection box
    When User clicks on Fewest Players button
    Then User verifies contests number in contests table
    When User clicks on third contest
    Then User verifies game dates