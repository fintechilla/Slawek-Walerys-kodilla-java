package com.kodilla.testing.weather.stub;

import java.util.HashMap;

public class TemperaturesStub implements Temperatures{
    @Override
    public HashMap<Integer, Double>getTemperatures(){
        HashMap<Integer, Double>stubResult = new HashMap<>();

        //dummy data
        stubResult.put(0, 25.2);
        stubResult.put(1, 25.8);
        stubResult.put(2, 25.3);
        stubResult.put(3, 25.7);
        stubResult.put(4, 26.2);

        return stubResult;
    }
}
