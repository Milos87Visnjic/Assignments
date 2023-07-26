Feature: Qa Training

  @dragAndDrop
  Scenario: Handling drag and drop
    Given User navigates to Guru Drag and Drop Page
    When User moves bank to Debit Side Account
    Then User validate the message in the Account placeholder
    When User moves an amount to Debit side amount placeholder
    Then User validate Debit side amount place holder
    When User moves sales to Credit side Account placeholder
    Then User validates credit side account placeholder
    When User moves an amount to credit side amount placeholder
    Then User validates credit side amount placeholder
    And User prints result table
    And User verifies perfect message
