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

class AgedBrieItem implements UpdatableItem {
    private final Item item;

    public AgedBrieItem(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        increaseQuality();
        decreaseSellIn();
        if (isExpired()) increaseQuality();
    }

    private void increaseQuality() {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }

    private void decreaseSellIn() {
        item.setSellIn(item.getSellIn() - 1);
    }

    private boolean isExpired() {
        return item.getSellIn() < 0;
    }
}

class BackstagePassItem implements UpdatableItem {
    private final Item item;

    public BackstagePassItem(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        increaseQuality();
        if (item.getSellIn() < 11) increaseQuality();
        if (item.getSellIn() < 6) increaseQuality();
        decreaseSellIn();
        if (isExpired()) dropQualityToZero();
    }

    private void increaseQuality() {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }

    private void decreaseSellIn() {
        item.setSellIn(item.getSellIn() - 1);
    }

    private boolean isExpired() {
        return item.getSellIn() < 0;
    }

    private void dropQualityToZero() {
        item.setQuality(0);
    }
}

class SulfurasItem implements UpdatableItem {
    @Override
    public void update() {
        // "Sulfuras" quality does not change
    }
}
