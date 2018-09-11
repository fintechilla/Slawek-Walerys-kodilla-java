package com.kodilla.good.patterns.food2Door;

import com.kodilla.good.patterns.food2Door.garbage.ProductOrderService;

public class ProcessorExecuter {
    public ProcessorExecuter() {
    }

    public void execute(OrderRequest orderRequest) {
        if (orderRequest.getSupplier().getName().equals("EKO")) {
            OrderProcessorInterface orderProcessor = new OrderProcessorEKO(
                    new MailService(),
                    new ProductOrderService(),
                    new ProductOrderRepository());
            orderProcessor.process(orderRequest);
            System.out.println("Transaction done!-----------------");
        } else if (orderRequest.getSupplier().getName().equals("ExtraFoodShop")) {
            OrderProcessorInterface orderProcessor = new OrderProcessorExtraFoodShop(
                    new MailService(),
                    new ProductOrderService(),
                    new ProductOrderRepository());
            orderProcessor.process(orderRequest);
            System.out.println("Transaction done!-----------------");
        } else if (orderRequest.getSupplier().getName().equals("HealthyShop")) {
            OrderProcessorInterface orderProcessor = new OrderProcessorExtraFoodShop(
                    new MailService(),
                    new ProductOrderService(),
                    new ProductOrderRepository());
            orderProcessor.process(orderRequest);
            System.out.println("Transaction done!-----------------");
        } else if (orderRequest.getSupplier().getName().equals("GlutenFreeShop")) {
            OrderProcessorInterface orderProcessor = new OrderProcessorExtraFoodShop(
                    new MailService(),
                    new ProductOrderService(),
                    new ProductOrderRepository());
            orderProcessor.process(orderRequest);
            System.out.println("Transaction done!-----------------");
        } else {
            System.out.println("No valid supplier chosen");
        }
    }
}

