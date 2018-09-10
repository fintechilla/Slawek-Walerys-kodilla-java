package com.kodilla.good.patterns.food2Door;

import java.time.LocalDateTime;

public class OrderRequest {
    private User user;
    private LocalDateTime orderTime;
    private Supplier  supplier;

    public OrderRequest(User user, LocalDateTime orderTime, Supplier supplier) {
        this.user = user;
        this.orderTime = orderTime;
        this.supplier = supplier;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public Supplier getSupplier() { return supplier; }
}
