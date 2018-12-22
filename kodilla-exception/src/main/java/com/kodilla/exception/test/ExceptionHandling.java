package com.kodilla.exception.test;
//Module 8.3
public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            secondChallenge.probablyIWillThrowException(0, 2);
        } catch (Exception e) {
            System.out.println("Exception  detected!! And the message is: " + e);
            //e.printStackTrace();
        } finally {
            System.out.println("Done anyway!");
        }
    }
}
