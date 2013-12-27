package com.thoughtworks.ns.collection;



import java.util.*;

public class ShoppingCart {

    private Map products;
    private int amount;

    public ShoppingCart() {
        products = new HashMap<Product,Integer>();
    }

    public int getAmount() {
        return amount;
    }

    public void add(Product product){
        if (products.containsKey(product))
        {
            int productAmount = ((Integer)products.get(product) + 1);
            products.put(product,productAmount);
        }
        else
        {
            products.put(product,1);
        }
        amount++;
    }

    public Product findProduct(String name) {
        Product product = new Product(name);
        if(products.containsKey(product))
            return product;
        return null;
    }

    public Product remove(String name) {
        Product product = findProduct(name);
        products.remove(product);
        amount--;
        return product;
    }

    public int findProductNum(String name) {
     return products.containsKey(new Product(name))?(Integer)products.get(new Product(name)):0;
    }

    public double totalPrice() {
        double totalPrice = 0.;
        for (Object key : products.keySet()) {
            totalPrice += ((Integer)products.get(key))  * ((Product)key).getPrice();
        }
        return totalPrice;
    }

    public void add(Map _products, int _amount) {
        products.putAll(_products);
        amount += _amount;
    }
}
