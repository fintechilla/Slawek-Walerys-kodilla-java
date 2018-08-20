package com.kodilla.testing.weather.stub;

import java.util.HashMap;

public interface Temperatures {
    //first element of the map - identifier of the station

    //second element of the map - reading in Celsius

    HashMap<Integer, Double> getTemperatures();

}
