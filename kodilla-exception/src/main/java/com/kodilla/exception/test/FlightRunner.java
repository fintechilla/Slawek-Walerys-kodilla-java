package com.kodilla.exception.test;

public class FlightRunner {
    public static void main(String[] args) throws RouteNotFoundException {
        String cityFrom = "London";
        String cityTo = "Bath";
        Flight flight = new Flight(cityFrom, cityTo);
        FlightSimulator flightSimulator = new FlightSimulator();

        boolean flying = flightSimulator.findFlight(flight);

        if(flying){
            System.out.println("The connection to " + cityTo + "  is possible");
        }else {
            throw new RouteNotFoundException("The flight to " + cityTo + " is not a valid connection");
        }
    }
}
