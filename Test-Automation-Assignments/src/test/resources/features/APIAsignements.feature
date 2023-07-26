Feature: APIAssignements

  @apiUsa
  Scenario: Get population of USA
    Given Navigate to USA population page
    And Get population data info

  @postRequest
  Scenario: Post request assignment
    Given Make post Request
    And Make put request

