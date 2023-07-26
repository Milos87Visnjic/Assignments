Feature: QA Practice
  @book
  Scenario: Ability to handle an element in nested shadow root
    Given Navigate Books page
    And Input a book name in shadowDom
    When Click on item title
    Then Get item title in detail page
    When Click on preview button
    Then verify book preview is opened