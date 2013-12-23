package com.thoughtworks.ns.collection;

import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;



public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @Before
    public void setUp() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void should_get_amount() throws Exception {
        assertThat(shoppingCart.getAmount(), is(0));
    }

    @Test
    public void should_add_product() throws Exception {
        shoppingCart.add(new Product("a"));
        assertThat(shoppingCart.getAmount(), is(1));
    }

    @Test
    public void should_add_3_product() {
        for (int i = 0;i < 3;i++) {
            shoppingCart.add(new Product(" "));
        }
        assertThat(shoppingCart.getAmount(), is(3));
    }

    @Test
    public void should_found_product_NULL() throws Exception {
        assertEquals(null,shoppingCart.findProduct("b"));
//        assertThat(shoppingCart.findProduct("b").equals(null),is(true));
    }

    @Test
    public void should_found_product_a() throws Exception {
        Product product = new Product("a");
        shoppingCart.add(product);
        assertThat(shoppingCart.findProduct("a").equals(product), is(true));
    }

    @Test
    public void should_remove_product_a_not_exist() throws Exception {
        assertThat(shoppingCart.remove("a"),is(nullValue()));
    }

    @Test
    public void should_remove_product_a_exist() {
        Product product = new Product("a");
        shoppingCart.add(product);
        assertThat(shoppingCart.remove("a").equals(product), is(true));
    }

    @Test
    public void should_find_number_of_product() {
        for(int i = 0;i < 3;i++)
            shoppingCart.add(new Product("a"));
        assertThat(shoppingCart.findProductNum("a"), is(3));
    }

    @Test
    public void should_product_a_have_price_5() {
        Product product = new Product("a", 5);
        assertThat(product.getPrice(), is(5.));
    }

    @Test
    public void should_two_a_product_total_price_is_10() {
        shoppingCart.add(new Product("a" , 5));
        shoppingCart.add(new Product("a" , 5));

        assertThat(shoppingCart.totalPrice(), is(10.));
    }

    public  Map products = new HashMap(){
        {
            put("a", Arrays.asList(new Double[]{5., 5., 5.}));
            put("b", Arrays.asList(new Double[]{3.}));
            put("c", Arrays.asList(new Double[]{2., 2.}));
            put("d", Arrays.asList(new Double[]{1., 1., 1.,1.}));
        };
    };

    @Test
    public void should_total_price_11() {
        shoppingCart.add(products);
        assertThat(shoppingCart.totalPrice(), is(26.));
    }

}
