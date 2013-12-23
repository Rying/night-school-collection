package com.thoughtworks.ns.collection;

import com.google.common.collect.HashMultiset;

import java.util.*;

public class ShoppingCart {

    private Map products;
    private int amount;

    public ShoppingCart() {
        products = new HashMap<String,List<Double>>();
    }

    public int getAmount() {
        return amount;
    }

    public void add(Product product){
        if (products.containsKey(product.name))
        {
            ((List)products.get(product.name)).add(product.getPrice());
        }
        else
        {
            List<Double> list = new ArrayList();
            list.add(product.getPrice());
            products.put(product.name,list);
        }
        amount++;
    }

    public Product findProduct(String name) {
//        for (int i = 0;i<products.size();i++) {
//            if (products.)
//                return ((Product)products.get(i));
//        }
        if(products.containsKey(name))
            return new Product(name);
        return null;
    }

    public Product remove(String name) {
        Product product = findProduct(name);
        products.remove(product);
        return product;
    }

    public int findProductNum(String name) {
        return products.containsKey(name)?((List)products.get(name)).size():0;
    }

    public double totalPrice() {
        double totalPrice = 0.;
        for (Object key : products.keySet()) {
            List list = (List)products.get(key);
            totalPrice += list.size()*(double)list.get(0);
        }
        return totalPrice;
    }

    public void add(Map<Integer, Product> _products) {
        products.putAll(_products);
    }
}
