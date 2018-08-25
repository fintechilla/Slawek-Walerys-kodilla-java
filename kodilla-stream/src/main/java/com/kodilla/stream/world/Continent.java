package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public class Continent {

    private List<Country> countryList = new ArrayList<>();

    public final List<Country> getCountries(){
        return countryList;
    }
    public final void addCountry(Country country){
        countryList.add(country);
    }
    public List<Country> getCountryList() {
        return countryList;
    }
}
