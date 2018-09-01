package com.kodilla.exception.test;

public class RouteNotFoundException extends Exception{
    public RouteNotFoundException(final String message) {
        super(message);
        System.out.println("Message: Try another city");
    }
}
