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
}
