package com.contest;

public class Product extends Item {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String NORMAL = "Normal";

    public Product(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        if (quality < 0) {
            throw new IllegalArgumentException("quality should not be negative.");
        }
        if (quality > 50) {
            throw new IllegalArgumentException("quality should be less than 50.");
        }
    }

    public int getSellIn() {
        return super.sellIn;
    }

    public int getQuality() {
        return super.quality;
    }

    public Product updateSellInAndQuality() {
        if (AGED_BRIE.equals(name)) {
            return new Product(AGED_BRIE, sellIn - 1, quality + 1);
        }
        if (quality == 0) {
            return new Product(NORMAL, sellIn - 1, 0);
        }
        if (sellIn <= 0 && quality > 2) {
            return new Product(NORMAL, sellIn - 1, quality - 2);
        }
        if (sellIn <= 0 && quality == 1) {
            return new Product(NORMAL, sellIn - 1, 0);
        }
        return new Product(NORMAL, sellIn - 1, quality - 1);
    }
}
