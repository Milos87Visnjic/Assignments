Feature: QA Abilities

  @hub
  Scenario: shadow dom
    Given navigate tp selectorHub practice page
    And type name in enterName box
    And handle closed shadowRoot

  @domIframe
  Scenario: iframe in shadow root
    Given navigate tp selectorHub iframe shadowdom practice page
    And type text in destiny box
    And hover over close button

    @iframeDom
    Scenario: shadow root in iframe
      Given navigate to selectorsHub shadowRoot in iframe
      And type text in