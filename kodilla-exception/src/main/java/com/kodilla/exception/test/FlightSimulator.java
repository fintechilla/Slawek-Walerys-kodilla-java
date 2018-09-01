package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSimulator {
    public static Flight findFlight(Flight flight) {
        HashMap<String, Boolean> airportMap = new HashMap<String, Boolean>();
        airportMap.put("Warsaw", true);
        airportMap.put("London", true);
        airportMap.put("Paris", true);
        airportMap.put("Chicago", true);
        airportMap.put("Bath", false);

        Flight result = new Flight();
        //Searching for a Departure Airport
        for (Map.Entry<String, Boolean> entry : airportMap.entrySet()) {
            if (entry.getKey().equals(flight.getDepartureAirport()) && entry.getValue()) {
                //departureAirportExists = true;
                result.setDepartureAirport(entry.getKey());
            }
        }
        //Searching for an Arrival Airport
        for (Map.Entry<String, Boolean> entry : airportMap.entrySet()) {
            if (entry.getKey().equals(flight.getArrivalAirport()) && entry.getValue()) {
                //arrivalAirportExists= true;
                result.setArrivalAirport(entry.getKey());
            }
        }
        return result;
    }
}
