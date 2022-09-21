package com.gildedrose.item;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ItemTest {

    @Test
    void item_should_loose_1_quality_and_sell_in_by_day() {
        Item item = Item.create("item", 1, 10);
        item.updateQuality();
        assertThat(item.toString()).isEqualTo("item, 0, 9");
    }

    @Test
    void item_should_loose_2_quality_by_day_when_sell_in_is_under_0() {
        Item item = Item.create("item", 0, 10);
        item.updateQuality();
        assertThat(item.toString()).isEqualTo("item, -1, 8");
    }

    @Test
    void time_should_have_no_effect_on_sulfuras() {
        Item sulfuras = Item.create("Sulfuras, Hand of Ragnaros", 0, 10);
        sulfuras.updateQuality();
        assertThat(sulfuras.toString()).isEqualTo("Sulfuras, Hand of Ragnaros, 0, 10");

        sulfuras = Item.create("Sulfuras, Hand of Ragnaros", -10, 99);
        sulfuras.updateQuality();
        assertThat(sulfuras.toString()).isEqualTo("Sulfuras, Hand of Ragnaros, -10, 99");
    }

    @Test
    void aged_brie_should_gain_1_quality_by_day() {
        Item brie = Item.create("Aged Brie", 1, 5);
        brie.updateQuality();
        assertThat(brie.toString()).isEqualTo("Aged Brie, 0, 6");
    }

    @Test
    void aged_brie_should_gain_2_quality_by_day_when_sell_in_is_under_0() {
        Item brie = Item.create("Aged Brie", 0, 6);
        brie.updateQuality();
        assertThat(brie.toString()).isEqualTo("Aged Brie, -1, 8");
    }

    @Test
    void backstage_pass_should_gain_1_quality_by_day() {
        Item pass = Item.create("Backstage passes to a TAFKAL80ETC concert", 11, 5);
        pass.updateQuality();
        assertThat(pass.toString()).isEqualTo("Backstage passes to a TAFKAL80ETC concert, 10, 6");
    }

    @Test
    void backstage_pass_should_gain_2_quality_by_day_when_sell_in_is_under_10() {
        Item pass = Item.create("Backstage passes to a TAFKAL80ETC concert", 10, 6);
        pass.updateQuality();
        assertThat(pass.toString()).isEqualTo("Backstage passes to a TAFKAL80ETC concert, 9, 8");
    }

    @Test
    void backstage_pass_should_gain_3_quality_by_day_when_sell_in_is_under_5() {
        Item pass = Item.create("Backstage passes to a TAFKAL80ETC concert", 5, 16);
        pass.updateQuality();
        assertThat(pass.toString()).isEqualTo("Backstage passes to a TAFKAL80ETC concert, 4, 19");
    }

    @Test
    void backstage_pass_should_have_0_quality_by_day_when_sell_in_is_under_0() {
        Item pass = Item.create("Backstage passes to a TAFKAL80ETC concert", 0, 31);
        pass.updateQuality();
        assertThat(pass.toString()).isEqualTo("Backstage passes to a TAFKAL80ETC concert, -1, 0");
    }
}