package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : this.items) {
            // Progresses through the sellIn count down.
            item.sellIn -= 1;

            // Legendary item's don't change value.
            if (isLegendary(item.name)) {
                continue;
            }

            if (isAgedBrie(item.name)) {
                item.quality = increaseQualityToCap(item, calculateDelta(item, 1));
            } else if (areBackStagePasses(item.name)) {
                if (item.sellIn < 0) {
                    item.quality = 0;
                } else {
                    if (item.sellIn < 6) {
                        item.quality = increaseQualityToCap(item, 3);
                    } else if (item.sellIn < 11) {
                        item.quality = increaseQualityToCap(item, 2);
                    } else {
                        item.quality = increaseQualityToCap(item, 1);
                    }
                }
            } else {
                item.quality = decreaseQualityToFloor(item, calculateDelta(item, 1));
            }
        }
    }

    private boolean isAgedBrie(String itemName) {
        return itemName.toLowerCase().contains("aged brie") ? true : false;
    }

    private boolean isLegendary(String itemName) {
        return itemName.toLowerCase().contains("sulfuras") ? true : false;
    }

    private boolean areBackStagePasses(String itemName) {
        return itemName.toLowerCase().contains("backstage passes") ? true : false;
    }

    private boolean isConjured(String itemName) {
        return itemName.toLowerCase().contains("conjured") ? true : false;
    }

    // Increments the item's quality to 50.
    private int increaseQualityToCap(Item item, int increment) {
        return item.quality < 50 ? item.quality + increment : 50;
    }

    // Decreases the item's quality to 0.
    private int decreaseQualityToFloor(Item item, int decrement) {
        int value = item.quality - decrement;
        return value < 0 ? 0 : value;
    }

    // Calculates the delta to be applied using relevant multipliers.
    private int calculateDelta(Item item, int value) {
        // Multiplier for quality doubles if it a Conjured item.
        int multiplier = isConjured(item.name) ? 2 : 1;
        // Multiplier for quality doubles if item is passed sellby.
        multiplier *= item.sellIn < 0 ? 2 : 1;
        // Applies multiplier to the value.
        return value *= multiplier;
    }
}
