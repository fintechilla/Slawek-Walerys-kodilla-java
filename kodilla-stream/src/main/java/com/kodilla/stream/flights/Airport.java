package com.kodilla.stream.flights;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Airport {
//    private final String name;
    private final String location;
    private static final Set<Airport>destinations = new HashSet<>();

    public Airport(String location) {
//        this.name = name;
        this.location = location;
    }
    public void addDestination(Airport airport){
        destinations.add(airport);
    }
    public boolean removeDestination(Airport airport){
        return destinations.remove(airport);
    }

    public String getLocation() {
        return location;
    }

    public Set<Airport> getDestinations() {
        return destinations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        return getLocation() != null ? getLocation().equals(airport.getLocation()) : airport.getLocation() == null;
    }

    @Override
    public int hashCode() {
        return getLocation() != null ? getLocation().hashCode() : 0;
    }

    private Set<String> getDestinationsOfLocations() {
        return destinations.stream()
                .map(x->x.getLocation())
                .collect(Collectors.toSet());
    }

    public Set<String> getLocationsOfDestinationsOfDestinations() {
        return destinations.stream()
                .flatMap(user -> user.getDestinations().stream())
                .filter(user -> user != this)
                .map(Airport::getLocation)
                .collect(Collectors.toSet());
    }
}
