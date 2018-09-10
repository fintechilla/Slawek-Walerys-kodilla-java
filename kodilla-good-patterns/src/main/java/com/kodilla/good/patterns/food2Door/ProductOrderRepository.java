package com.kodilla.good.patterns.food2Door;

import java.time.LocalDateTime;

public class ProductOrderRepository implements OrderRepository {
    public void createProductOrder(User user, LocalDateTime orderTime, Supplier supplier){

    }

    public void createOrder(User user, LocalDateTime orderTime, Supplier supplier) {
        System.out.println("This is createOrderRepository for supplier: " + supplier.getName() + "; product: " + supplier.getProduct()
        + "; quantity: " + supplier.getQuantity());
    }
}
