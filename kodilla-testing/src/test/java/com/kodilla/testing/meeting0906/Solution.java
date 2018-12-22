package com.kodilla.testing.meeting0906;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

        int pair1 = numberOfPairs(new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20});
        int pair2 = numberOfPairs(new int[]{20, 20});
        int pair3 = numberOfPairs(new int[]{10, 20, 30, 40, 50});
        if (pair1 == 3 && pair2 == 1 && pair3 == 0) {
            System.out.println("Znaleziono poprawną liczbę par");
        } else {
            System.out.println("Znaleziono błędną liczbę par");
        }
    }

    public static int numberOfPairs(int[] array) {
        int  len = array.length;
        Map<Integer, Integer> numberList = new HashMap<>();
        for(int number:array){
            if(numberList.containsKey(number)){
                numberList.put(number, numberList.get(number) + 1);
            } else {
                numberList.put(number, 1);
            }
        }
        return numberList.values().stream()
                .map(x->x/2)
                .mapToInt(x->x)
                .sum();
    }
}