package com.kodilla.stream.flights;

import java.util.ArrayList;
import java.util.List;

public class Airports {
    public final List<Airport> airports = new ArrayList<>();
    public  final String name;

    public Airports(String name) {
        this.name = name;
    }
    public void addAirport(Airport airport){
        airports.add(airport);
    }
    public boolean removeAirport(Airport airport){
        return airports.remove(airport);
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public String getName() {
        return name;
    }
}
