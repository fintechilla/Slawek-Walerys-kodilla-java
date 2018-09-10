package com.kodilla.good.patterns.food2Door.garbage;

import com.kodilla.good.patterns.food2Door.OrderService;
import com.kodilla.good.patterns.food2Door.Supplier;
import com.kodilla.good.patterns.food2Door.User;

import java.time.LocalDateTime;

public class ProductOrderService implements OrderService {
    private User user;
    private LocalDateTime orderTime;
    private Supplier supplier;

    public ProductOrderService() {
    }

    public boolean order(User user, LocalDateTime orderTime, Supplier supplier) {
        this.user = user;
        this.orderTime = orderTime;
        this.supplier = supplier;
        return true;
    }

    @Override
    public void createOrder(User user, LocalDateTime orderTime, Supplier supplier) {

    }
}
