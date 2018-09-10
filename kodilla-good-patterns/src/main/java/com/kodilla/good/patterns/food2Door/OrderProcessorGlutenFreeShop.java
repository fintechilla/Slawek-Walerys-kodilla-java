package com.kodilla.good.patterns.food2Door;

public class OrderProcessorGlutenFreeShop implements OrderProcessorInterface{
    private InfoService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public OrderProcessorGlutenFreeShop(final InfoService informationService,
                                       final OrderService orderService,
                                       final OrderRepository orderRepository) {
        //super(informationService, orderService, orderRepository);
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
            System.out.println("GlutenFreeShop processing own process...");
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
