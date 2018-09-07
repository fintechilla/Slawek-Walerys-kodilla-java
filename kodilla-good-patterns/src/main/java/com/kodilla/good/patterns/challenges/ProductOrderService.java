package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class ProductOrderService implements OrderService{
        private User user;
        private LocalDateTime orderTime;
        private String product;

    @Override
    public boolean order(User user, LocalDateTime orderTime, String product) {
        this.user = user;
        this.orderTime = orderTime;
        this.product = product;
        return true;
    }
}

