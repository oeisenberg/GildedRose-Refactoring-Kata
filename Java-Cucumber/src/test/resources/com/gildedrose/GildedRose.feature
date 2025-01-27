Feature: Gilded Rose quality
  I want to know if the quality is updated properly

  Scenario: Checking Brie's quality increases
    Given The item as "Aged Brie" with sellby 1 and quality 10
    When I update the quality
    Then I should get item quality as 11

  Scenario: Checking Brie's quality increases when sellby is passed
    Given The item as "Aged Brie" with sellby 0 and quality 10
    When I update the quality
    Then I should get item quality as 12

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

  Scenario: Checking a normal item's quality remains at 0 and doesn't go negative
    Given The item as "normal item" with sellby 0 and quality 0
    When I update the quality
    Then I should get item quality as 0

  Scenario: Checking a backstage pass's quality increases correctly when there are five days or less remaining
    Given The item as "Backstage passes to a TAFKAL80ETC concert" with sellby 5 and quality 10
    When I update the quality
    Then I should get item quality as 13

  Scenario: Checking a backstage pass's quality increases correctly when there are ten days or less remaining
    Given The item as "Backstage passes to a TAFKAL80ETC concert" with sellby 10 and quality 10
    When I update the quality
    Then I should get item quality as 12

  Scenario: Checking a backstage pass's quality increases correctly when there are more than ten days remaining
    Given The item as "Backstage passes to a TAFKAL80ETC concert" with sellby 16 and quality 10
    When I update the quality
    Then I should get item quality as 11

  Scenario: Checking a backstage pass's quality falls to 0 if after the sellby
    Given The item as "Backstage passes to a TAFKAL80ETC concert" with sellby -1 and quality 10
    When I update the quality
    Then I should get item quality as 0

  Scenario: Checking a conjured item's quality decreases
    Given The item as "Conjured Mana Cake" with sellby 1 and quality 10
    When I update the quality
    Then I should get item quality as 8

  Scenario: Checking a conjured item's quality decreases twice as fast if past sellby
    Given The item as "Conjured Mana Cake" with sellby 0 and quality 10
    When I update the quality
    Then I should get item quality as 6

  Scenario: Checking a conjured item's quality remains at 0 and doesn't go negative
    Given The item as "Conjured Mana Cake" with sellby 0 and quality 0
    When I update the quality
    Then I should get item quality as 0