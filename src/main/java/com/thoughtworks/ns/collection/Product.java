package com.thoughtworks.ns.collection;

public class Product{
    String name;
    private double price;

    public Product(String _name) {
           name = _name;
    }

    public Product(String _name, double _price) {
        name = _name;
        price = _price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (name != null ? !name.equals(product.name) : product.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;

        result = name != null ? name.hashCode() : 0;

        return result;
    }
}

