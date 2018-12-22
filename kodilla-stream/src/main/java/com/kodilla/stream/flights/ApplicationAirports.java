package com.kodilla.stream.flights;

import java.util.Set;
import java.util.stream.Collectors;

public class ApplicationAirports {
    public static Airports generateNetOfAirports() {
        Airport airport1 = new Airport("Warsaw");
        Airport airport2 = new Airport("Lodz");
        Airport airport3 = new Airport("Krakow");
        Airport airport4 = new Airport("Katowice");
        Airport airport5 = new Airport("Szczecin");
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
    public static void main(String[] args) {
        Airports airportsList = generateNetOfAirports();
        String departureAirport = "Gdansk";
        System.out.println("all flights departing from city - " + departureAirport);
        Set<Airport> airs = airportsList.getAirports().stream()
                .filter(x->x.getLocation().equals(departureAirport))
                //.map(x->x.getDestinations())
                .flatMap(x -> x.getDestinations().stream())
                .collect(Collectors.toSet());
//                .map(x->x.getLocation())
//                .filter(x -> !x.equals(departureAirport))
//                .forEach(System.out::println)
        ;
        System.out.println(airs.toString());

        //Znalezienie wszystkich lotów do danego miasta
        String arrivalAirport = "Gdansk";
        System.out.println("Find all flights to a given city - " + arrivalAirport);
        System.out.println("Assume that if you fly to a given city, there is also an identical return flight");

        airportsList.getAirports().stream()
                .filter(x->x.getLocation().equals(arrivalAirport))
                .flatMap(x -> x.getDestinations().stream())
                .map(x->x.getLocation())
                .filter(x -> !x.equals(arrivalAirport))
                .forEach(System.out::println)
        ;
    }
}
