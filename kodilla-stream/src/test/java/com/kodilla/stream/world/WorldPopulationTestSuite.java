package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WorldPopulationTestSuite {
    @Test
    public void testWorldPopulationQuantity() {
        //Given
        List<Country> countryList = new ArrayList<>();
        Continent europe = new Continent(countryList);

        Country england = new Country("85000000");
        europe.addCountry(england);
        Country germany = new Country("80000000");
        europe.addCountry(germany);

        Country italy = new Country("100000000");
        europe.addCountry(italy);
        Country poland = new Country("38000000");
        europe.addCountry(poland);

        Continent america = new Continent(countryList);

        Country unitedStates = new Country("330000000");
        america.addCountry(unitedStates);
        Country mexico = new Country("130000000");
        america.addCountry(mexico);

        Country brasil = new Country("150000000");
        america.addCountry(brasil);
        Country argentina = new Country("90000000");
        america.addCountry(argentina);

        World world = new World();
        List<Continent>continentList = new ArrayList<>();
//        world.addContinent(europe);
//        world.addContinent(america);
        continentList.add(europe);
        continentList.add(america);

        //When
        BigDecimal totalPopulation = world.getPeopleQuantity(continentList);

//        System.out.println(totalPopulation);
        //Then
        BigDecimal expectedPopulation = new BigDecimal("2006000000");
        Assert.assertEquals(expectedPopulation, totalPopulation);

    }
}
