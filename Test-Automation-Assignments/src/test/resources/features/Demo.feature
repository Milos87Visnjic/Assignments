Feature: Handle Tables

  @demo
  Scenario: Tables
    Given User navigates to Demo Page
    And User scroll down to Sortable Data Tables
    When User click on Sortable Data Tables
    Then User verifies Example One is displayed
    And User verifies first table
    And User verifies LastNames and FirstNames are in ascending order
    And User prints rows and column numbers
    And User prints second row and third column

  @outline
  Scenario Outline:
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    When User log in "<usernames>" and "<password>"
    Then User verify "<avatar>"
    Examples:
      | usernames                   | password   | avatar   |
      | testerqatester101@gmail.com | 654321\"qW | avatar   |
      | testerqatester@yopmail.com  | 654321\"qW | initials |


  @names
  Scenario Outline: Ability to Login with Parameters and use data tables
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    And User logs in with the parameters "testerqatester101@gmail.com " and "654321\"qW"
    And User clicks on the hamburger menu
    And User clicks on "<leaguesName>" button in Hamburger Menu
    And User verifies "<leaguesName>" in selectionBox
    Examples:
      | leaguesName               |
      | International             |
      | Occupational              |
      | Influencer - Placeholders |

  @dynamicLocators
  Scenario Outline: Ability to login with parameters and use data tables and parameters
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    And User logs in with the parameters "testerqatester101@gmail.com " and "654321\"qW"
    And User clicks on the hamburger menu
    And User clicks on "<leaguesName>" button in Hamburger Menu
    And User verifies "<leaguesName>" in selectionBox
    Examples:
      | leaguesName               |
      | International             |
      | Occupational              |
      | Influencer - Placeholders |


  @verifyTopRankingTiersClicked
  Scenario Outline: Ability to verify top ranking tiers are clicked
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    And User logs in with the parameters "testerqatester101@gmail.com " and "654321\"qW"
    And User clicks on the hamburger menu
    And User clicks on individual item on the menu
    And User clicks on region button
    And User clicks on top ranking button
    When User clicks on "<tiers>"
    Then verify that "<tiers>" are clicked
    Examples:
      | tiers    |
      | diamond  |
      | platinum |
      | gold     |
      | silver   |
      | bronze   |

  @Assignment_7
  Scenario Outline: Ability to login with parameters and validate top rankings tiers
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    And User logs in with the parameters "testerqatester101@gmail.com " and "654321\"qW"
    And User clicks on the hamburger menu
    And User clicks on Individuals button in dropdown menu
    And User clicks on Regions button
    And User clicks on TopRankings button
    When User clicks on "<tiers>"
    And User verifies that "<tiers>" is "<selected>"
    Examples:
      | tiers    | selected |
      | diamond  | true     |
      | platinum | true     |
      | gold     | true     |
      | silver   | true     |
      | bronze   | true     |



    @windowsAndTabs
    Scenario: Handling multiple windows and tabs
      Given user navigates to HeroKupappWindows url
      When  user clicks on Click Here
      Then  Print current url
      When user goes back to previos window and Click on Elemental Selenium
      Then Print current url for Elemental Selenium
      And user opens a new tab
      When user Navigates to elementalselenium page in that tab
      Then Print number of tabs that are opened
      And Compare second and third tab URLs if they are equal
      And Navigate to the main window
      And Print the header in the main window

  @tabs
  Scenario: Ability to handle windowHandles
    Given User navigates to demo windows page
    When User clicks click here button
    Then User handles new tab
    When User clicks on Elemental Selenium button
    Then User handles Elemental Selenium Tab
    And User opens a new tab
    When User Navigates to Elemental selenium page
    Then User prints tab numbers
    And User compares tabs three and tabs four
    And User prints main window header

  @jseDemo
  Scenario: jse
    Given Navigate to herOku remove elements page
    And print title using jse
    And draw border addRemove Element text
    And flash the color of addElement
    And take screenShot
    And add alert

  @shadowDom
  Scenario: Ability to handle shadow root
    Given Navigates to herOku app shadow dom page
    And Get first shadow dom element


