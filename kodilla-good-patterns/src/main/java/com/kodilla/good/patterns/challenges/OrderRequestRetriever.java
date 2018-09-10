package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderRequestRetriever {
    public OrderRequest retrieve(){
        User user = new User("John", "Miller");

        LocalDateTime orderTime = LocalDateTime.of(2017, 10, 11,
                12, 01, 01
        );
        String product = "Eggs";
        return new OrderRequest(user, orderTime, product);
    }
}
