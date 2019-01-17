package com.kodilla.stream.flights;

import org.junit.Assert;
import org.junit.Test;

public class AirportsTestSuite {
    public Airports generateAirports(){
        Airport  airport1 = new Airport("Warsaw");
        Airport airport2 = new Airport("Lodz");
        Airport  airport3 = new Airport("Krakow");
        Airport airport4 = new Airport("Katowice");
        Airport airport5 =  new Airport("Szczecin");
        Airport airport6 = new Airport("Gdansk");
        Airport airport7 = new Airport("Wroclaw");
        //When
        airport1.addDestination(airport2);
        airport1.addDestination(airport3);
        airport1.addDestination(airport3);
        airport1.addDestination(airport4);
        airport1.addDestination(airport5);
        airport1.addDestination(airport6);
        airport7.addDestination(airport7);

        airport2.addDestination(airport1);

        airport3.addDestination(airport1);
        airport3.addDestination(airport7);

        airport4.addDestination(airport1);
        airport4.addDestination(airport5);
        airport4.addDestination(airport6);

        airport5.addDestination(airport1);
        airport5.addDestination(airport4);
        airport5.addDestination(airport6);

        airport6.addDestination(airport1);
        airport6.addDestination(airport7);
        airport6.addDestination(airport4);
        airport6.addDestination(airport5);

        airport7.addDestination(airport1);
        airport7.addDestination(airport6);
        airport7.addDestination(airport3);

        Airports project = new Airports("Poland");
        project.addAirport(airport1);
        project.addAirport(airport2);
        project.addAirport(airport3);
        project.addAirport(airport4);
        project.addAirport(airport6);
        project.addAirport(airport7);

        return project;
    }
    @Test
    public void testAllDestinationsFromALocation(){
        //Given
        Airports project = generateAirports();
        //Then
        Assert.assertEquals(31 , project.getAirports().stream()
                .flatMap(x->x.getLocationsOfDestinationsOfDestinations().stream())
        .filter(x->!x.equals("Warsaw"))
        .count()
        );
    }

}