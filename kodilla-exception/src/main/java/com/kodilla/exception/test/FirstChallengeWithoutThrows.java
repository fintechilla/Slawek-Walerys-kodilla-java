package com.kodilla.exception.test;

public class FirstChallengeWithoutThrows {
    public double divide(double a, double b) {
        double result = 0;
        try {
            result =  a / b;
        } catch (ArithmeticException e) {
            System.out.println("Exception: Division by ZERO is not allowed, message: " + e);
        } finally {
            System.out.println("We did it!!");
        }
        return result;
    }


    public static void main(String[] args) {
        FirstChallengeWithoutThrows firstChallenge = new FirstChallengeWithoutThrows();
        double result = firstChallenge.divide(3, 0);
            System.out.println("Result is " + result);
    }
}
