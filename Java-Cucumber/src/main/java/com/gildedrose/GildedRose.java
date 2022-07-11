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
                    if (item.quality > 0) {
                        item.quality = item.quality - increment;
                    }
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
                        if (item.quality > 0) {
                            item.quality = item.quality - increment;
                        }
                }
            }
        }
    }

    private int increaseQualityToCap(Item item, int increment) {
        if (item.quality < 50) {
            return item.quality + increment;
        } else {
            return 50;
        }
    }
}
