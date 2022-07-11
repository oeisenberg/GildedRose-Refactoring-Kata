Feature: Gilded Rose quality
  I want to know if the quality is updated properly

  Scenario: Checking Brie's quality increases
    Given The item as "Aged Brie" with sellby 1 and quality 10
    When I update the quality
    Then I should get item quality as 11

  Scenario: Checking Brie's quality doesn't increase past 50
    Given The item as "Aged Brie" with quality 50
    When I update the quality
    Then I should get item quality as 50

  Scenario: Checking Legendary value stays constant
    Given The item as "Sulfuras, Hand of Ragnaros" with quality 80
    When I update the quality
    Then I should get item quality as 80

  Scenario: Checking a normal item's quality decreases
    Given The item as "normal item" with sellby 1 and quality 10
    When I update the quality
    Then I should get item quality as 9

  Scenario: Checking a normal item's quality decreases twice as fast if past sellby
    Given The item as "normal item" with sellby 0 and quality 10
    When I update the quality
    Then I should get item quality as 8