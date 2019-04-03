package com.contest;


import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class GildedRoseTest {

    @Test
    public void quality_of_normal_product_should_decrease_1_each_day() {
        Product product = new Product("Normal", 10, 20);

        Product updatedProduct = product.updateSellInAndQuality();

        assertThat(updatedProduct.getSellIn(), is(9));
        assertThat(updatedProduct.getQuality(), is(19));
    }

    @Test
    public void quality_of_normal_product_should_be_0_if_quality_is_0() {
        Product product = new Product("Normal", 10, 0);

        Product updatedProduct = product.updateSellInAndQuality();

        assertThat(updatedProduct.getSellIn(), is(9));
        assertThat(updatedProduct.getQuality(), is(0));
    }

    @Test
    public void quality_of_normal_product_should_degrade_twice_when_sell_by_date_passes() {
        Product product = new Product("Normal", 0, 10);

        Product updatedProduct = product.updateSellInAndQuality();

        assertThat(updatedProduct.getSellIn(), is(-1));
        assertThat(updatedProduct.getQuality(), is(8));
    }
    @Test

    public void quality_of_normal_product_should_degrade_twice_when_sell_by_date_passes_but_not_negative() {
        Product product = new Product("Normal", 0, 1);

        Product updatedProduct = product.updateSellInAndQuality();

        assertThat(updatedProduct.getSellIn(), is(-1));
        assertThat(updatedProduct.getQuality(), is(0));
    }
}
