package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : this.items){

            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            switch (item.name) {
                case "Aged Brie":
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                        if (item.sellIn < 11) {
                            item.quality = item.quality + 1;
                        }

                        if (item.sellIn < 6) {
                            item.quality = item.quality + 1;
                        }
                    }
                    break;
                default:
                    if (item.quality > 0) {
                        item.quality = item.quality - 1;
                    }
            }


            item.sellIn = item.sellIn - 1;
            

            if (item.sellIn < 0) {
                switch (item.name) {
                    case "Aged Brie":
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                        break;
                    case "Backstage passes to a TAFKAL80ETC concert":
                        item.quality = item.quality - item.quality;
                        break;
                    default:
                        if (item.quality > 0) {
                            item.quality = item.quality - 1;
                        }
                }
            }
        }
    }
}
