package com.kodilla.good.patterns.solid;

import java.time.LocalDateTime;

public interface RentalService {
    boolean rent(User user, LocalDateTime rentFrom, LocalDateTime rentTo);
}
