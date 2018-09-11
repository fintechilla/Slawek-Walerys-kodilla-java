package com.kodilla.good.patterns.food2Door;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class OrderRequestRetriever {

    public OrderRequest retrieve(){

        User user;
        Supplier supplier;
        LocalDateTime orderTime;
        Map<String, OrderRequest> orders = new HashMap<>();

        user = new User("John", "Miller");
        orderTime = LocalDateTime.of(2017, 10, 11, 12, 01, 01
        );
        supplier = new Supplier("EKO", "Eggs", 100);
        orders.put(supplier.getName(), new OrderRequest(user, orderTime, supplier));

        supplier = new Supplier("ExtraFoodShop", "Bread", 10);
        orders.put(supplier.getName(), new OrderRequest(user, orderTime, supplier));

        supplier = new Supplier("HealthyShop", "Tomatoes", 5);
        orders.put(supplier.getName(), new OrderRequest(user, orderTime, supplier));

        supplier = new Supplier("GlutenFreeShop", "Rye bread", 4);
        orders.put(supplier.getName(), new OrderRequest(user, orderTime, supplier));

        OrderRequest result = orders.get("GlutenFreeShop");
        return result;
        //return new OrderRequest(result.getUser(), result.getOrderTime(), result.getSupplier());
    }
}
