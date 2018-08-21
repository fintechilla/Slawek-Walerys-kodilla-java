package com.kodilla.testing.collection;
import org.junit.*;

import java.util.ArrayList;

public class CollectionTestSuite {
    @Before
    public void before(){
        System.out.println("Test case: begin");
    }
    @After
    public void after(){
        System.out.println("Test case: end");
    }
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Test suite: begin");
    }


    @Test
    public void testOddNumbersExterminatorEmptyList(){
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        ArrayList<Integer> numList = new ArrayList<>();
        //When
        ArrayList<Integer> result = exterminator.exterminate(numList);
        System.out.println("Testing " + result);

        //Then
        Assert.assertEquals(numList, result);
    }
    @Test
    public void testOddNumbersExterminator(){
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        ArrayList<Integer> allNumList = new ArrayList<>();
        ArrayList<Integer> evenNumList = new ArrayList<>();
        int n = 9;
        //initialize a list of integers from 1..n
        for(int i = 0; i < n; i++){
            allNumList.add(i+1);
        }
        //initialize a list of even integers from 1..n
        for(Integer num:allNumList){
            if(num % 2 == 0){
                evenNumList.add(num);
            }
        }

        //When
        ArrayList<Integer> result = exterminator.exterminate(allNumList);

        //Then
        Assert.assertEquals(evenNumList, result);
    }

}
