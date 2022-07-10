Feature: Gilded Rose quality
  I want to know if the quality is updated properly

  Scenario: Checking Brie's quality increases
    Given The item as "Aged Brie" with quality 10
    When I update the quality
    Then I should get item quality as 11

  Scenario: Checking Legendary value stays constant
    Given The item as "Sulfuras, Hand of Ragnaros" with quality 80
    When I update the quality
    Then I should get item quality as 80