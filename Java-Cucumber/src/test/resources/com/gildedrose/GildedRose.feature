Feature: Gilded Rose quality
  I want to know if the quality is updated properly

  Scenario: Checking foo
    Given The item as "fixme"
    When I update the quality
    Then I should get item as "foo"

  Scenario: Checking Legendary value stays constant
    Given The item as "Sulfuras, Hand of Ragnaros" with quality 80
    When I update the quality
    Then I should get item quality as 80