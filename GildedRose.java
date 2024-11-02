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
        String itemName = item.getName();
        if ("Aged Brie".equals(itemName)) return new AgedBrieItem(item);
        if ("Backstage passes to a TAFKAL80ETC concert".equals(itemName)) return new BackstagePassItem(item);
        if ("Sulfuras, Hand of Ragnaros".equals(itemName)) return new SulfurasItem(item);
        return new RegularItem(item);
    }

    public void updateQuality() {
        items.forEach(UpdatableItem::update);
    }
}
