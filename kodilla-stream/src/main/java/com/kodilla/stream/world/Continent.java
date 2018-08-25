package com.kodilla.stream.world;

import java.util.List;

public class Continent {

    List<Country> countryList;

    public Continent(List<Country> countryList) {
        this.countryList = countryList;
    }
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
