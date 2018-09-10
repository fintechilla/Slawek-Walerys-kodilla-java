package com.kodilla.good.patterns.food2Door;

public class OrderProcessorEKO implements OrderProcessorInterface {//} extends OrderProcessorAbstract {
    private InfoService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;
    private OrderProcessorInterface orderProcessorInterface;

    public OrderProcessorEKO(OrderProcessorInterface orderProcessorInterface) {
        this.orderProcessorInterface = orderProcessorInterface;
    }

    public OrderProcessorEKO(final InfoService informationService,
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
            System.out.println("EKO processing own process...");
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
