package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {

        //Given
        int n = 20;
        int[] numbers = new int[n];
        numbers = generateArray(n);

        //When
        double result = ArrayOperations.getAverage(numbers);

        //Then
        Assert.assertEquals(9.5, result, .1);


    }
    public int[] generateArray(int n){
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++){
            numbers[i] = i;
        }
        return numbers;
    }


}
