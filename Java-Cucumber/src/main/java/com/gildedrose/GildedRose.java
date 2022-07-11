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

            // Increment for quality doubles if it a Conjured item.
            int increment = item.name.equals("Conjured Mana Cake") ? 2 : 1;

            switch (item.name) {
                case "Aged Brie":
                    item.quality = increaseQualityToCap(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                        // Increase by 1 by default
                        item.quality = increaseQualityToCap(item);
                        if (item.sellIn < 11) {
                            // Increases again
                            item.quality = increaseQualityToCap(item);
                        }
                        if (item.sellIn < 6) {
                            // Increases again
                            item.quality = increaseQualityToCap(item);
                        }
                    break;
                default:
                    if (item.quality > 0) {
                        item.quality = item.quality - increment;
                    }
            }

            item.sellIn = item.sellIn - 1;

            if (item.sellIn < 0) {
                switch (item.name) {
                    case "Aged Brie":
                        item.quality = increaseQualityToCap(item);
                        break;
                    case "Backstage passes to a TAFKAL80ETC concert":
                        item.quality = 0;
                        break;
                    default:
                        if (item.quality > 0) {
                            item.quality = item.quality - increment;
                        }
                }
            }
        }
    }

    private int increaseQualityToCap(Item item) {
        if (item.quality < 50) {
            return item.quality + 1;
        } else {
            return 50;
        }
    }
}
