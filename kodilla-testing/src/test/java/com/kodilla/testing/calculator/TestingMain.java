package com.kodilla.testing.calculator;

public class TestingMain {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        if(calculator.add(1, 3) == 4){
            System.out.println("Addition success!");
        } else {
            System.out.println("Addition failed");
        }
        if(calculator.subtract(1, 3) == -2){
            System.out.println("Subtraction success!");
        } else {
            System.out.println("Subtraction failed");
        }

    }
}
