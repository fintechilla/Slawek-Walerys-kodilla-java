package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderRequest {
    private User user;
    private LocalDateTime orderTime;
    private String product;

    public OrderRequest(User user, LocalDateTime orderTime, String product) {
        this.user = user;
        this.orderTime = orderTime;
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public String getProduct() {
        return product;
    }
}
