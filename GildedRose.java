package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

class GildedRose {
    private final List<UpdatableItem> items;

    public GildedRose(Item[] items) {
        this.items = new ArrayList<>();
        for (Item item : items) {
            this.items.add(createUpdatableItem(item));
        }
    }

    private UpdatableItem createUpdatableItem(Item item) {
        switch (item.getName()) {
            case "Aged Brie":
                return new AgedBrieItem(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassItem(item);
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasItem(item);
            default:
                return new RegularItem(item);
        }
    }

    public void updateQuality() {
        for (UpdatableItem item : items) {
            item.update();
        }
    }
}
