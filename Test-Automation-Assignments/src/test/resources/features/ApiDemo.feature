Feature: Api Training

  @apiDemo
  Scenario: Ability to handle get request
    Given Navigate to leagues URL
    And Get leagues data
    And Get leagues data using hamcrest methods