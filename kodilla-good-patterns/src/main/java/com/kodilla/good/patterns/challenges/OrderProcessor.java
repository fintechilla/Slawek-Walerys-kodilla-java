package com.kodilla.good.patterns.challenges;

public class OrderProcessor {
    private InfoService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public OrderProcessor(final InfoService informationService, final OrderService rentalService, final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = rentalService;
        this.orderRepository = orderRepository;
    }
    public OrderDto process(final OrderRequest orderRequest){
        boolean isOrdered = orderService.order(orderRequest.getUser(), orderRequest.getOrderTime(), orderRequest.getProduct());
        if(isOrdered){
            informationService.inform(orderRequest.getUser());
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getOrderTime(), orderRequest.getProduct());
            return new OrderDto(orderRequest.getUser(), true);
        }else{
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}
