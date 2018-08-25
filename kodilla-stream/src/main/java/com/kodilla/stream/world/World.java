package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class World {
    private List<Continent>continentList = new ArrayList<>();
    public BigDecimal getPeopleQuantity(){
        BigDecimal totalQuantity = continentList.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
        return totalQuantity;
    }
    public void addContinent(Continent continent){
        continentList.add(continent);
    }

}
