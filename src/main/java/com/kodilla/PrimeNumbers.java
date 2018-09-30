package com.kodilla;

public class PrimeNumbers {

    public static void main(String[] args) {
        PrimeNumbers primeNumbers = new PrimeNumbers();
        int result = calcPrime(7);
        System.out.println(result);
    }

    public static int calcPrime(int n) {
        if (n == 1 || n == 2) {
            return n;
        } else if (n <= 0) {
            return 0;
        }

        int counterPrime = 3;
        int lastNumber = 2;
        while (counterPrime <= n) {
//            lastNumber++;
            if (isPrime(lastNumber + 1)) {
                counterPrime++;
            }
            lastNumber++;
        }
        return lastNumber;
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
