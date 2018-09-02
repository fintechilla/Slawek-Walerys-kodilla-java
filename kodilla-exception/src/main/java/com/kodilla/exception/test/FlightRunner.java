package com.kodilla.exception.test;

public class FlightRunner {
    public static void main(String[] args) throws RouteNotFoundException {
        String cityFrom = "London";
        String cityTo = "Lodz";
        Flight flight = new Flight(cityFrom, cityTo);
        FlightSimulator flightSimulator = new FlightSimulator();

        boolean flying = flightSimulator.findFlight(flight);

        if(flying){
            System.out.println("The connection is possible");
        }else{
            throw new RouteNotFoundException("from " + cityFrom + " to " + cityTo + " is not a valid connection");
        }

//        if (flying.getDepartureAirport() != null) {
//            System.out.println("flying from: " + flying.getDepartureAirport() + ". Airport is valid");
//        } else {
//
//        }
//
//        if (flying.getArrivalAirport() != null) {
//            System.out.println("flying to: " + flying.getArrivalAirport() + ". Airport is valid");
//        } else {
//            throw new RouteNotFoundException(cityTo + " is not a valid Arrival Airport");
//        }
    }
}
