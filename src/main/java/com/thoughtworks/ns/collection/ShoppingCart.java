package com.thoughtworks.ns.collection;

public class ShoppingCart {
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void add(Product product) {
        amount++;
    }
}
