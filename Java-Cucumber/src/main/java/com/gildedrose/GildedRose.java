package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : this.items) {
            // Progresses through the sellIn count down.
            item.sellIn = item.sellIn - 1;

            // Legendary item's don't change value.
            if (isLegendary(item.name)) {
                continue;
            }

            switch (item.name) {
                case "Aged Brie":
                    item.quality = increaseQualityToCap(item, calculateDelta(item, 1));
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
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
                    break;
                default:
                    item.quality = decreaseQualityToFloor(item, calculateDelta(item, 1));
            }
        }
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

    // Calculates the delta to be applying any relevant mutliplies.
    private int calculateDelta(Item item, int value) {
        // Multiplier for quality doubles if it a Conjured item.
        int multiplier = isConjured(item.name) ? 2 : 1;
        // Multiplier for quality doubles if item is passed sellby.
        multiplier *= item.sellIn < 0 ? 2 : 1;
        // Applies multiplier to the value.
        return value *= multiplier;
    }
}
