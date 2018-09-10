package com.kodilla.good.patterns.food2Door;

import java.time.LocalDateTime;

public class OrderDto {
    private User user;
    private Supplier supplier;
    private LocalDateTime orderTime;
    private boolean isOrdered;

    public OrderDto(User user, LocalDateTime orderTime, Supplier supplier, boolean isOrdered) {
        this.user = user;
        this.supplier = supplier;
        this.orderTime = orderTime;
        this.isOrdered = isOrdered;
    }

    public User getUser() {
        return user;
    }

    public boolean isOrdered() {
        return isOrdered;
    }

    public Supplier getSupplier() { return supplier;  }

    public LocalDateTime getOrderTime() { return orderTime; }
}
