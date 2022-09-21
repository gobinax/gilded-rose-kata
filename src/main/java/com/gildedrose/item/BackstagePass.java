package com.gildedrose.item;

public class BackstagePass extends Item {
    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePass(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        decreaseSellIn();
        increaseQuality();
        if (getSellIn() < 10) increaseQuality();
        if (getSellIn() < 5) increaseQuality();
        if (getSellIn() < 0) zeroQuality();
    }

}
