package com.kodilla.stream.flights;

import java.util.Set;

public class ApplicationFlights {
    public static void main(String[] args){
        FlightProcessor flightProcessor = new FlightProcessor();
        String departureCity = "krakow";
        String arrivalCity = "gdansk";
        Set<Flight> departures = flightProcessor.findFlightsFrom(departureCity);
        System.out.println(departures);

        Set<Flight> arrivals   = flightProcessor.findFlightsFrom(arrivalCity);

        Set<Flight> indirectFlights = flightProcessor.findAllFlightsFromTo(departureCity, arrivalCity);

        System.out.println("Departures: " + departures);
        System.out.println("Arrivals: " + arrivals);
        System.out.println("Indirect flights: " + indirectFlights);
    }
}
