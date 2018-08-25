package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.List;

public class World {

    public BigDecimal getPeopleQuantity(List<Continent> continentList){
        BigDecimal totalQuantity = continentList.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
        return totalQuantity;
    }
}
