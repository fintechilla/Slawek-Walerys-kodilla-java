package com.kodilla.spring.calculator;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalculatorTestSuite {
    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");

        Calculator calculator = context.getBean(Calculator.class);
        //When
        calculator.add(2.1, 3.2);
        calculator.sub(2.1, 3.2);
        calculator.mul(2.1, 3.2);
        calculator.div(2.1, 3.2);
        //Then
    }

}
