package com.kodilla.good.patterns.solid;

import java.time.LocalDateTime;

public interface RentalRepository {
    void createRental(User user, LocalDateTime rentFrom, LocalDateTime rentTo);
}
