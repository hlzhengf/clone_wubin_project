package com.contest;

public class Product extends Item {
    public Product(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public int getSellIn() {
        return super.sellIn;
    }

    public int getQuality() {
        return super.quality;
    }

    public Product updateSellInAndQuality() {
        if (quality == 0) {
            return new Product("Normal", sellIn - 1, 0);
        }
        if (sellIn <= 0 && quality > 2) {
            return new Product("Normal", sellIn - 1, quality - 2);
        }
        return new Product("Normal", sellIn - 1, quality - 1);
    }
}
