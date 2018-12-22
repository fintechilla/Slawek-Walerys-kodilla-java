package com.kodilla.good.patterns.food2Door.garbage;

import com.kodilla.good.patterns.food2Door.*;

public class OrderProcessor {
    private InfoService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public OrderProcessor(final InfoService informationService,
                          final OrderService orderService,
                          final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final OrderRequest orderRequest){
        boolean isOrdered = orderService.order(orderRequest.getUser(),
                orderRequest.getOrderTime(),
                orderRequest.getSupplier()
        );
        if(isOrdered){
            informationService.inform(orderRequest.getUser(), orderRequest.getOrderTime(), orderRequest.getSupplier());
            orderRepository.createOrder(orderRequest.getUser(),
                    orderRequest.getOrderTime(),
                    orderRequest.getSupplier()
            );
            return new OrderDto(orderRequest.getUser(), orderRequest.getOrderTime(), orderRequest.getSupplier(), true);
        }else{
            return new OrderDto(orderRequest.getUser(), orderRequest.getOrderTime(), orderRequest.getSupplier(), false);
        }
    }
}
