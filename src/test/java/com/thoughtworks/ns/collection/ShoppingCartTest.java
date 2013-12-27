package com.thoughtworks.ns.collection;

import org.junit.Before;
import org.junit.Test;

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
    }

    @Test
    public void should_found_product_a() throws Exception {
        Product product = new Product("a");
        shoppingCart.add(product);
        assertThat(shoppingCart.findProduct("a").equals(product), is(true));
    }

    @Test
    public void should_found_product_b() {
        Product product = new Product("b",2);
        shoppingCart.add(product);
        assertThat(shoppingCart.findProduct("b").equals(product), is(true));
    }

    @Test
    public void should_remove_product_a_not_exist() throws Exception {
        assertThat(shoppingCart.remove("a"),is(nullValue()));
    }

    @Test
    public void should_remove_product_a_exist() {
        Product product = new Product("a", 5);
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
            put(new Product("a" , 5.), 3);
            put(new Product("b" , 3.), 1);
            put(new Product("c" , 2.), 2);
            put(new Product("d" , 1.), 4);
        };
    };

    public int amount = 10;

    @Test
    public void should_total_price_26() {
        shoppingCart.add(products,amount);
        assertThat(shoppingCart.totalPrice(), is(26.));
    }

    @Test
    public void should_remove_one_product_amount_should_be_less() {
        shoppingCart.add(new Product(" "));
        shoppingCart.remove(" ");
        assertThat(shoppingCart.getAmount(), is(0));
    }

}
