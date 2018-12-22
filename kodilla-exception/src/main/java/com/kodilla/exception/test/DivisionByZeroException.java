package com.kodilla.exception.test;

public class DivisionByZeroException extends Exception{
    public DivisionByZeroException(String message) {
        super(message);
        System.out.println("DivisionByZeroException!!!");
    }
}
