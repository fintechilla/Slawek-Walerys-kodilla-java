package com.kodilla.exception.test;

public class FlightRunner {
    public static void main(String[] args) throws RouteNotFoundException {
        String cityFrom = "London";
        String cityTo = "Lodz";
        Flight flight = new Flight(cityFrom, cityTo);
        FlightSimulator flightSimulator = new FlightSimulator();
        Flight flying = flightSimulator.findFlight(flight);

        if (flying.getDepartureAirport() != null) {
            System.out.println("flying from: " + flying.getDepartureAirport() + ". Airport is valid");
        } else {
            throw new RouteNotFoundException(cityFrom + " is not a valid Departure Airport");
        }

        if (flying.getArrivalAirport() != null) {
            System.out.println("flying to: " + flying.getArrivalAirport() + ". Airport is valid");
        } else {
            throw new RouteNotFoundException(cityTo + " is not a valid Arrival Airport");
        }
    }
}
