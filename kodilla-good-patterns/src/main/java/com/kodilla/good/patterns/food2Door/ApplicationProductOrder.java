package com.kodilla.good.patterns.food2Door;

public class ApplicationProductOrder {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        ProcessorExecuter processorExecuter = new ProcessorExecuter();
        processorExecuter.execute(orderRequest);
    }
}
