package com.kodilla.good.patterns.food2Door;

public class OrderProcessorHealthyShop implements OrderProcessorInterface {

    private InfoService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;


    public OrderProcessorHealthyShop(final InfoService informationService,
                                     final OrderService orderService,
                                     final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto process(OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest.getUser(),
                orderRequest.getOrderTime(),
                orderRequest.getSupplier()
        );
        if (isOrdered) {
            System.out.println("HealthyShop processing own process...");
            informationService.inform(orderRequest.getUser(), orderRequest.getOrderTime(), orderRequest.getSupplier());
            orderRepository.createOrder(orderRequest.getUser(),
                    orderRequest.getOrderTime(),
                    orderRequest.getSupplier()
            );

            return new OrderDto(orderRequest.getUser(), orderRequest.getOrderTime(), orderRequest.getSupplier(), isOrdered);
        } else {
            return new OrderDto(orderRequest.getUser(), orderRequest.getOrderTime(), orderRequest.getSupplier(), isOrdered);
        }
    }
}

