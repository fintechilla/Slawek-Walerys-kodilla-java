package com.kodilla.good.patterns.solid;

import java.time.LocalDateTime;

public class RentRequestRetriever {
    public RentRequest retrieve(){
        User user = new User("John", "Miller");

        LocalDateTime rentFrom = LocalDateTime.of(2017, 10, 11, 12, 01, 01
        );
        LocalDateTime rentTo = LocalDateTime.of(2017, 10, 18, 12, 01, 01);
        return new RentRequest(user, rentFrom, rentTo);
    }
}
