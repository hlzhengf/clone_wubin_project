package com.contest;

public class Product extends Item {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String NORMAL = "Normal";
    public static final String SULFURAS = "Sulfuras";
    public static final String BACKSTAGE_PASS = "Backstage Pass";
    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;
    public static final int QUALITY_SULFURAS = 80;
    public static final String QUALITY_SHOULD_NOT_BE_NEGATIVE = "quality should not be negative.";
    public static final String QUALITY_SHOULD_BE_LESS_THAN_50 = "quality should be less than 50.";
    public static final String QUALITY_OF_SULFURAS_SHOULD_ALWAYS_BE_80 = "quality of sulfuras should always be 80.";

    public Product(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        if (SULFURAS.equals(name) && quality != QUALITY_SULFURAS) {
            throw new IllegalArgumentException(QUALITY_OF_SULFURAS_SHOULD_ALWAYS_BE_80);
        }
        if (!SULFURAS.equals(name) && quality < MIN_QUALITY) {
            throw new IllegalArgumentException(QUALITY_SHOULD_NOT_BE_NEGATIVE);
        }
        if (!SULFURAS.equals(name) && quality > MAX_QUALITY) {
            throw new IllegalArgumentException(QUALITY_SHOULD_BE_LESS_THAN_50);
        }
    }

    public String getName() {
        return super.name;
    }

    public int getSellIn() {
        return super.sellIn;
    }

    public int getQuality() {
        return super.quality;
    }

    public Product updateSellInAndQuality() {
        if (AGED_BRIE.equals(name) && quality >= MAX_QUALITY) {
            return new Product(AGED_BRIE, sellIn - 1, MAX_QUALITY);
        }
        if (AGED_BRIE.equals(name)) {
            return new Product(AGED_BRIE, sellIn - 1, quality + 1);
        }
        if (SULFURAS.equals(name)) {
            return new Product(SULFURAS, sellIn - 1, QUALITY_SULFURAS);
        }
        if (BACKSTAGE_PASS.equals(name) && sellIn > 10) {
            return new Product(BACKSTAGE_PASS, sellIn - 1, makeQualityInRange(quality + 1));
        }
        if (BACKSTAGE_PASS.equals(name) && sellIn > 5 && sellIn <= 10) {
            return new Product(BACKSTAGE_PASS, sellIn - 1, makeQualityInRange(quality + 2));
        }
        if (BACKSTAGE_PASS.equals(name) && sellIn > 0 && sellIn <= 5) {
            return new Product(BACKSTAGE_PASS, sellIn - 1, makeQualityInRange(quality + 3));
        }
        if (quality == MIN_QUALITY) {
            return new Product(NORMAL, sellIn - 1, MIN_QUALITY);
        }
        if (sellIn <= 0 && quality > 2) {
            return new Product(NORMAL, sellIn - 1, quality - 2);
        }
        if (sellIn <= 0 && quality == 1) {
            return new Product(NORMAL, sellIn - 1, MIN_QUALITY);
        }
        return new Product(NORMAL, sellIn - 1, quality - 1);
    }

    private int makeQualityInRange(int quality) {
        return quality > 50 ? 50 : quality;
    }
}
