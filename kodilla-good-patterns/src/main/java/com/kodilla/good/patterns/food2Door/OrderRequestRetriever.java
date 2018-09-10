package com.kodilla.good.patterns.food2Door;

import java.time.LocalDateTime;

public class OrderRequestRetriever {
    public OrderRequest retrieve(){
        User user = new User("John", "Miller");
        Supplier supplier = new Supplier("EKO", "Eggs", 100);
        //Supplier supplier = new Supplier("ExtraFoodShop", "Bread", 10);
        //Supplier supplier = new Supplier("HealthyShop", "Tomatoes", 5);
        //Supplier supplier = new Supplier("GlutenFreeShop", "Rye bread", 4);

        LocalDateTime orderTime = LocalDateTime.of(2017, 10, 11, 12, 01, 01
        );
//        String product = "Eggs";
//
//        String supplier = "Eko";
        return new OrderRequest(user, orderTime, supplier);
    }
}
