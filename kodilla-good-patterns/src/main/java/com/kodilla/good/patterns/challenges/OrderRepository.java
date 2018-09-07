package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.solid.User;

import java.time.LocalDateTime;

public interface ProductOrderRepository {
    void createOrder(User user, LocalDateTime orderTime, String productName);
}
