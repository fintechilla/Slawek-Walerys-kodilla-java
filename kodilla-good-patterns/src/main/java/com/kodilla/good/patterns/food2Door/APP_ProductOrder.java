package com.kodilla.good.patterns.food2Door;

import com.kodilla.good.patterns.food2Door.garbage.ProductOrderService;

public class APP_ProductOrder {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        if (orderRequest.getSupplier().getName() == "EKO") {
            OrderProcessorInterface orderProcessor = new OrderProcessorEKO(
                    new MailService(),
                    new ProductOrderService(),
                    new ProductOrderRepository());
            orderProcessor.process(orderRequest);
            System.out.println("Transaction done!-----------------");
        } else if (orderRequest.getSupplier().getName() == "ExtraFoodShop") {
            OrderProcessorInterface orderProcessor = new OrderProcessorExtraFoodShop(
                    new MailService(),
                    new ProductOrderService(),
                    new ProductOrderRepository());
            orderProcessor.process(orderRequest);
            System.out.println("Transaction done!-----------------");
        } else if (orderRequest.getSupplier().getName() == "HealthyShop") {
            OrderProcessorInterface orderProcessor = new OrderProcessorExtraFoodShop(
                    new MailService(),
                    new ProductOrderService(),
                    new ProductOrderRepository());
            orderProcessor.process(orderRequest);
            System.out.println("Transaction done!-----------------");
        } else if (orderRequest.getSupplier().getName() == "GlutenFreeShop") {
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
