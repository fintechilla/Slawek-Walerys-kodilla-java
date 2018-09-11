package com.kodilla.good.patterns.food2Door;

public class Order {
    private OrderRequest order;

    public Order(OrderRequest order) {
        this.order = order;
    }

    public OrderRequest getOrder() {
        return order;
    }

}
