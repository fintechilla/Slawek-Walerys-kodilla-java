package com.kodilla.exception.test;

public class ThirdChallenge {
    public double divide(double a, double b) throws DivisionByZeroException {
        if (b == 0) {
            throw new DivisionByZeroException("Division by ZERO not allowed");
        }
        return a / b;
    }

    public static void main(String[] args) {
        ThirdChallenge thirdChallenge = new ThirdChallenge();

        double result = 0;
        try {
            result = thirdChallenge.divide(2, 0);
        } catch (DivisionByZeroException e) {
            e.printStackTrace();
        }
        //System.out.println("Result is " + result);
    }
}
