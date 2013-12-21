package com.thoughtworks.ns.collection;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private int amount;
    private List products;

    public ShoppingCart() {
        products = new ArrayList<Product>();
    }

    public int getAmount() {
        return amount;
    }

    public void add(Product product){
        products.add(product);
        amount++;
    }

    public Product findProduct(String name) {
        for (int i = 0;i<products.size();i++) {
            if (((Product)products.get(i)).name.equals(name))
                return ((Product)products.get(i));
        }
        return null;
    }

    public Product remove(String name) {
        Product product = findProduct(name);
        products.remove(product);
        amount--;
        return product;
    }
}
