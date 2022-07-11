package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : this.items) {

            // Legendary item's don't change value.
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            // decrement for quality doubles if it a Conjured item.
            int decrement = item.name.equals("Conjured Mana Cake") ? 2 : 1;

            switch (item.name) {
                case "Aged Brie":
                    item.quality = increaseQualityToCap(item, 1);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                        if (item.sellIn < 6) {
                            item.quality = increaseQualityToCap(item, 3);
                        } else if (item.sellIn < 11) {
                            item.quality = increaseQualityToCap(item, 2);
                        } else {
                            item.quality = increaseQualityToCap(item, 1);
                        }
                    break;
                default:
                    item.quality = decreaseQualityToFloor(item, decrement);
            }

            item.sellIn = item.sellIn - 1;

            if (item.sellIn < 0) {
                switch (item.name) {
                    case "Aged Brie":
                        item.quality = increaseQualityToCap(item, 1);
                        break;
                    case "Backstage passes to a TAFKAL80ETC concert":
                        item.quality = 0;
                        break;
                    default:
                        item.quality = decreaseQualityToFloor(item, decrement);
                }
            }
        }
    }

    private int increaseQualityToCap(Item item, int increment) {
        if (item.quality < 50) {
            return item.quality + increment;
        }
        return 50;
    }

    private int decreaseQualityToFloor(Item item, int decrement) {
        int value = item.quality - decrement;
        if (value < 0) {
            return 0;
        }
        return value;
    }
}
