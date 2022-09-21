package com.gildedrose.item;

public class AgedBrie extends Item2 {
    public static final String NAME = "Aged Brie";

    public AgedBrie(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        decreaseSellIn();
        increaseQuality();
        if (getSellIn() < 0) increaseQuality();
    }
}
