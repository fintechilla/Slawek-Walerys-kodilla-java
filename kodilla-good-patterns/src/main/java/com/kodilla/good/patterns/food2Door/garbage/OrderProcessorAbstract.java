package com.kodilla.good.patterns.food2Door.garbage;

import com.kodilla.good.patterns.food2Door.*;

abstract class OrderProcessorAbstract {
    private InfoService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public OrderProcessorAbstract(final InfoService informationService,
                                  final OrderService orderService,
                                  final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }
    abstract OrderDto process (final OrderRequest orderRequest);
}
