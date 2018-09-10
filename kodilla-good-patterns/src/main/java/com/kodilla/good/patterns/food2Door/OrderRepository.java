package com.kodilla.good.patterns.food2Door;

import java.time.LocalDateTime;

public interface OrderRepository {
    void createOrder(User user, LocalDateTime orderTime, Supplier supplier);
}
