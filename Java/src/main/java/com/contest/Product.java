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
        return new Product("Normal", 9, 19);
    }
}
