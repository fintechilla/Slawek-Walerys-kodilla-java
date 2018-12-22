package com.kodilla.good.patterns.food2Door.garbage;

import com.kodilla.good.patterns.food2Door.OrderDto;
import com.kodilla.good.patterns.food2Door.OrderService;
import com.kodilla.good.patterns.food2Door.Supplier;
import com.kodilla.good.patterns.food2Door.User;

import java.time.LocalDateTime;

public class ProductOrderServiceEko implements OrderService {
    private User user;
    private LocalDateTime orderTime;
    private Supplier supplier;

    public ProductOrderServiceEko() {
    }

    public ProductOrderServiceEko(OrderDto orderDto ){ //User user, LocalDateTime orderTime, Supplier supplier) {
        this.user = orderDto.getUser();
        this.orderTime = orderDto.getOrderTime();
        this.supplier = orderDto.getSupplier();
    }

    @Override
    public boolean order(User user, LocalDateTime orderTime, Supplier supplier) {
        System.out.println("This is Product Order Service from EKO for product: " + supplier.getProduct());
        return true;
    }

    @Override
    public void createOrder(User user, LocalDateTime orderTime, Supplier supplier) {

    }
}
