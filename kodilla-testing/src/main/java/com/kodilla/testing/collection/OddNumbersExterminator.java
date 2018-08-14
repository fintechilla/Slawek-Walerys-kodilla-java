package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {

    public ArrayList<Integer> exterminate(ArrayList<Integer> list){
        ArrayList<Integer> newList = new ArrayList<>();
        for(Integer number:list){
            if(number % 2 == 0){
                newList.add(number);
            }
        }
        return newList;
    }
}
