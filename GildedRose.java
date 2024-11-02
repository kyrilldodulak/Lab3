package com.gildedrose;

interface UpdatableItem {
    void update();
}

class RegularItem implements UpdatableItem {
    private final Item item;

    public RegularItem(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        decreaseQuality();
        decreaseSellIn();
        if (isExpired()) decreaseQuality();
    }

    private void decreaseQuality() {
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }
    }

    private void decreaseSellIn() {
        item.setSellIn(item.getSellIn() - 1);
    }

    private boolean isExpired() {
        return item.getSellIn() < 0;
    }
}
