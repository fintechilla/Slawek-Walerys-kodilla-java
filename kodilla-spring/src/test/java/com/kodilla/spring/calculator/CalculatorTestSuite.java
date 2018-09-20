package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalculatorTestSuite {
    @Test
    public void testCalculationsAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        double a = 2.1;
        double b = 3.2;
        //When
        double result = calculator.add(a,b);
        //Then
        Assert.assertEquals(a + b, result, 0.001);
    }
    @Test
    public void testCalculationsSub() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");

        Calculator calculator = context.getBean(Calculator.class);
        double a = 2.1;
        double b = 3.2;
        //When
        double result = calculator.sub(a, b);
        //Then
        Assert.assertEquals(a - b, result, 0.001);
    }
    @Test
    public void testCalculationsMul() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");

        Calculator calculator = context.getBean(Calculator.class);
        double a = 2.1;
        double b = 3.2;
        //When
        double result = calculator.mul(a, b);
        //Then
        Assert.assertEquals(a * b, result, 0.001);
    }
    @Test
    public void testCalculationsDiv() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");

        Calculator calculator = context.getBean(Calculator.class);
        double a = 2.1;
        double b = 3.2;
        //When
        double result = calculator.div(a, b);
        //Then
        Assert.assertEquals(a / b, result, 0.001);
    }

}
