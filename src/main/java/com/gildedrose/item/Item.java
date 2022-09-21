package com.gildedrose.item;

public class Item {
    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;

    private final String name;
    private int sellIn;
    private int quality;

    protected Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public static Item create(String name, int sellIn, int quality) {
        switch (name) {
            case AgedBrie.NAME:
                return new AgedBrie(sellIn, quality);
            case Sulfuras.NAME:
                return new Sulfuras(sellIn, quality);
            case BackstagePass.NAME:
                return new BackstagePass(sellIn, quality);
            default:
                return new Item(name, sellIn, quality);
        }
    }

    public void updateQuality() {
        decreaseSellIn();
        decreaseQuality();
        if (getSellIn() < 0) {
            decreaseQuality();
        }
    }

    protected void decreaseSellIn() {
        sellIn--;
    }

    protected void increaseQuality() {
        quality = Math.min(MAX_QUALITY, quality + 1);
    }

    protected void decreaseQuality() {
        quality = Math.max(MIN_QUALITY, quality - 1);
    }

    protected void zeroQuality() {
        quality = 0;
    }

    protected int getSellIn() {
        return this.sellIn;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
