package com.kodilla.good.patterns.solid;

import java.time.LocalDateTime;

public class CarRentalService implements RentalService{
    private User user;
    private LocalDateTime rentFrom;
    private LocalDateTime rentTo;


    public CarRentalService() {
    }

    public boolean rent(User user, LocalDateTime rentFrom, LocalDateTime rentTo){
        this.user = user;
        this.rentFrom = rentFrom;
        this.rentTo = rentTo;
        return true;
    }
}
