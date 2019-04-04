package com.contest;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class ItemTest {
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();


    @Test
    public void quality_of_normal_product_should_decrease_1_each_day() {
        Product product = new Product(Product.NORMAL, 10, 20);

        Product updatedProduct = product.updateSellInAndQuality();

        assertThat(updatedProduct.getSellIn(), is(9));
        assertThat(updatedProduct.getQuality(), is(19));
    }

    @Test
    public void quality_of_normal_product_should_be_0_if_quality_is_0() {
        Product product = new Product(Product.NORMAL, 10, Product.MIN_QUALITY);

        Product updatedProduct = product.updateSellInAndQuality();

        assertThat(updatedProduct.getSellIn(), is(9));
        assertThat(updatedProduct.getQuality(), is(Product.MIN_QUALITY));
    }

    @Test
    public void quality_of_normal_product_should_degrade_twice_when_sell_by_date_passes() {
        Product product = new Product(Product.NORMAL, 0, 10);

        Product updatedProduct = product.updateSellInAndQuality();

        assertThat(updatedProduct.getSellIn(), is(-1));
        assertThat(updatedProduct.getQuality(), is(8));
    }

    @Test
    public void quality_of_normal_product_should_not_be_negative_when_sell_by_date_passes() {
        Product product = new Product(Product.NORMAL, 0, 1);

        Product updatedProduct = product.updateSellInAndQuality();

        assertThat(updatedProduct.getSellIn(), is(-1));
        assertThat(updatedProduct.getQuality(), is(Product.MIN_QUALITY));
    }

    @Test
    public void quality_of_normal_product_should_not_be_negative() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(Product.QUALITY_SHOULD_NOT_BE_NEGATIVE);

        Product product = new Product(Product.NORMAL, 0, -1);
    }

    @Test
    public void quality_of_normal_product_should_be_less_than_50() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(Product.QUALITY_SHOULD_BE_LESS_THAN_50);

        Product product = new Product(Product.NORMAL, 0, Product.MAX_QUALITY + 1);
    }

    @Test
    public void quality_of_aged_brie_should_increase_1_each_day() {
        Product product = new Product(Product.AGED_BRIE, 1, 49);

        Product updatedProduct = product.updateSellInAndQuality();

        assertThat(updatedProduct.getSellIn(), is(0));
        assertThat(updatedProduct.getQuality(), is(Product.MAX_QUALITY));
    }

    @Test
    public void quality_of_aged_brie_should_not_be_greater_than_50() {
        Product product = new Product(Product.AGED_BRIE, 1, Product.MAX_QUALITY);

        Product updatedProduct = product.updateSellInAndQuality();

        assertThat(updatedProduct.getSellIn(), is(0));
        assertThat(updatedProduct.getQuality(), is(Product.MAX_QUALITY));
    }

    @Test
    public void quality_of_aged_brie_should_not_be_negative() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(Product.QUALITY_SHOULD_NOT_BE_NEGATIVE);

        Product product = new Product(Product.AGED_BRIE, 0, -1);
    }

    @Test
    public void quality_of_aged_brie_should_be_less_than_50() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage(Product.QUALITY_SHOULD_BE_LESS_THAN_50);

        Product product = new Product(Product.AGED_BRIE, 0, Product.MAX_QUALITY + 1);
    }

}
