package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            secondChallenge.probablyIWillThrowException(0, 2);
        } catch (Exception e) {
            System.out.println("Exception  detected!!");
            e.printStackTrace();
        } finally {
            System.out.println("Done anyway!");
        }
    }
}
