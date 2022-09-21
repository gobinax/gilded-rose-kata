package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GoldenMasterTest {

    @ParameterizedTest
    @CsvSource(value = {
            "+5 Dexterity Vest; 10; 20",
            "Aged Brie; 2; 0",
            "Elixir of the Mongoose; 5; 7",
            "Sulfuras, Hand of Ragnaros; 0; 80",
            "Sulfuras, Hand of Ragnaros; -1; 80",
            "Backstage passes to a TAFKAL80ETC concert; 15; 20",
            "Backstage passes to a TAFKAL80ETC concert; 10; 49",
            "Backstage passes to a TAFKAL80ETC concert; 5;49",
            "Conjured Mana Cake; 3; 6"
    }, delimiterString = ";")
    void refactor_should_be_the_same_as_golden_master(String name, int sellIn, int quality) {
        // GIVEN
        int days = 100;
        Item itemLegacy = new Item(name, sellIn, quality);
        Item2 itemRefactored = new Item2(name, sellIn, quality);

        // WHEN
        for (int day = 0; day < days; day++) {
            itemLegacy.updateQuality();
            itemRefactored.updateQuality();
            assertThat(itemRefactored.toString())
                    .describedAs("day " + day)
                    .isEqualTo(itemLegacy.toString());
        }

    }

}
