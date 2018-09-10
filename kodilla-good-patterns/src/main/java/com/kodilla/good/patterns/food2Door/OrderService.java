package com.kodilla.good.patterns.food2Door;

import java.time.LocalDateTime;

public interface OrderService {
    boolean order(User user, LocalDateTime orderTime, Supplier supplier);

    void createOrder(User user, LocalDateTime orderTime, Supplier supplier);
}
