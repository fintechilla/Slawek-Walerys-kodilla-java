package com.kodilla.stream.flights;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightProcessor {
    private Set<Flight>flights = new HashSet<>();

    public FlightProcessor() {
        this.flights.add(new Flight("warsaw", "lodz"));
        this.flights.add(new Flight("warsaw", "poznan"));
        this.flights.add(new Flight("warsaw", "katowice"));
        this.flights.add(new Flight("warsaw", "krakow"));
        this.flights.add(new Flight("warsaw", "wroclaw"));
        this.flights.add(new Flight("warsaw", "gdansk"));
        this.flights.add(new Flight("warsaw", "szczecin"));
        this.flights.add(new Flight("krakow", "warsaw"));
    }
    public Set<Flight> findFlightsFrom(String departure){
        return flights.stream().filter(x->x.getDeparture()
                .equals(departure)).collect(Collectors.toSet());
    }

    public Set<Flight>  findFlightsTo(String arrival){
        return flights.stream().filter(x->x.getArrival().equals(arrival)).collect(Collectors.toSet());
    }

    public Set<Flight>  findAllFlightsFromTo(String departure, String  arrival){
        Set<Flight>departures = findFlightsFrom(departure);
        Set<Flight>arrivals = findFlightsTo(arrival);
        Set<Flight>result = new HashSet<>();
        for(Flight flight1:departures){
            for(Flight flight2:arrivals){
                if(flight1.getArrival().equals(flight2.getDeparture())){
                    result.add(flight1);
                    result.add(flight2);
                }
            }
        }
        return result;
    }
}
