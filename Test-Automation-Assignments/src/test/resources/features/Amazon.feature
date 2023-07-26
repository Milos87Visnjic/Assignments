Feature:Amazon

  @amazon
  Scenario: Dropdown Menu Amazon
    Given Navigate to "https://www.amazon.com/"
    And Click dont change button
    And Handle all departments menu
    And Type "java" in search menu
    And Select sort by high to low
    And Click on first item
    And Add 5 items to cart

