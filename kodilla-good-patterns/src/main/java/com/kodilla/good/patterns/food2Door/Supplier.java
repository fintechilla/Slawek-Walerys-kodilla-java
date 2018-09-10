package com.kodilla.good.patterns.food2Door;

public class Supplier {
    private String name;
    private String product;
    private double quantity;

    public Supplier(String name, String product, double quantity) {
        this.name = name;
        this.product = product;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }
}
