package com.thoughtworks.ns.collection;

import com.google.common.collect.*;


public class ShoppingCart {
    private ArrayListMultimap products;

    public ShoppingCart() {
        products = ArrayListMultimap.create();
    }

    public int getAmount() {
        return products.size();
    }

    public void add(Product product) {
        products.put(product.name, product.getPrice());
    }

    public Product findProduct(String name) {
        return products.containsKey(name) ? new Product(name) : null;
    }

    public Product remove(String name) {
        return products.removeAll(name).size() == 0 ? null : new Product(name);
    }

    public int findProductNum(String name) {
        return products.get(name).size();
    }

    public double totalPrice() {
        double totalPrice = 0.;
        for (Object value : products.values()) {
            totalPrice += (double) value;
        }
        return totalPrice;
    }

    public void add(ArrayListMultimap _products) {
        products.putAll(_products);
    }
}
