package com.kodilla.good.patterns.solid;

import java.time.LocalDateTime;

public class RentRequest{
    private User user;
    LocalDateTime rentFrom;
    LocalDateTime rentTo;

    public RentRequest(final User user, final LocalDateTime rentFrom, final LocalDateTime rentTo) {
        this.user = user;
        this.rentFrom = rentFrom;
        this.rentTo = rentTo;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getFrom() {
        return rentFrom;
    }

    public LocalDateTime getTo() {
        return rentTo;
    }
}
