package com.thoughtworks.ns.collection;

import com.google.common.collect.ArrayListMultimap;
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
    public void should_found_product_unavailable() throws Exception {
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
    public void should_remove_unavailable_product() throws Exception {
        assertThat(shoppingCart.remove("a"),is(nullValue()));
    }

    @Test
    public void should_remove_available_product() {
        Product product = new Product("a");
        shoppingCart.add(product);
        assertThat(shoppingCart.remove("a").equals(product), is(true));
    }

    @Test
    public void should_find_3_product() {
        for(int i = 0;i < 3;i++)
            shoppingCart.add(new Product("a"));
        assertThat(shoppingCart.findProductNum("a"), is(3));
    }

    @Test
    public void should_product_a_values_5() {
        Product product = new Product("a", 5);
        assertThat(product.getPrice(), is(5.));
    }

    @Test
    public void should_total_price_of_a_product_is_10() {
        shoppingCart.add(new Product("a" , 5));
        shoppingCart.add(new Product("a" , 5));

        assertThat(shoppingCart.totalPrice(), is(10.));
    }

    @Test
    public void should_total_price_is_11() {
        ArrayListMultimap products = ArrayListMultimap.create();

        products.put("a", 5.);
        products.put("a", 5.);
        products.put("a", 5.);
        products.put("b",3.);
        products.put("b",3.);
        products.put("c", 2.);
        products.put("d",1.);
        products.put("d",1.);
        products.put("d",1.);
        products.put("d",1.);
        products.put("d",1.);

        shoppingCart.add(products);
        assertThat(shoppingCart.totalPrice(), is(28.));
    }

}
