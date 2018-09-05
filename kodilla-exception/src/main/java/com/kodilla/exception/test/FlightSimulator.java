package com.kodilla.exception.test;

import java.util.HashMap;

public class FlightSimulator {
    public static boolean findFlight(Flight flight) {
        HashMap<String, Boolean> airportMap = new HashMap<String, Boolean>();
        airportMap.put("Warsaw", true);
        airportMap.put("London", true);
        airportMap.put("Paris", true);
        airportMap.put("Chicago", true);
        airportMap.put("Bath", false);

        boolean result = false;
        //Searching for an Arrival Airport
//        for (Map.Entry<String, Boolean> entry : airportMap.entrySet()) {
//            if (entry.getKey().equals(flight.getArrivalAirport()) && entry.getValue()) {
//                //arrivalAirportExists= true;
//                result = true;
//            }
//        }
        for (String key : airportMap.keySet()) {
            if (key.equals(flight.getArrivalAirport())) {
                if(airportMap.get(key))
                result = true;
            }
        }
        return result;
    }
}
