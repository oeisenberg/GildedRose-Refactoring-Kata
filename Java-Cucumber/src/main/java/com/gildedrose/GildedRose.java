package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            switch (items[i].name) {
                case "Aged Brie":
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                        if (items[i].sellIn < 11) {
                            items[i].quality = items[i].quality + 1;
                        }

                        if (items[i].sellIn < 6) {
                            items[i].quality = items[i].quality + 1;
                        }
                    }
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    if (items[i].quality > 0) {
                        items[i].quality = items[i].quality - 1;
                    }
            }


            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                switch (items[i].name) {
                    case "Aged Brie":
                        if (items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1;
                        }
                        break;
                    case "Backstage passes to a TAFKAL80ETC concert":
                        items[i].quality = items[i].quality - items[i].quality;
                        break;
                    case "Sulfuras, Hand of Ragnaros":
                        // Quality never changes.
                        break;
                    default:
                        if (items[i].quality > 0) {
                            items[i].quality = items[i].quality - 1;
                        }
                }
            }
        }
    }
}
