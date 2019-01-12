package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicOrderPrice(){
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        //When
        BigDecimal price = order.getCost();
        //Then
        assertEquals(new BigDecimal(10), price);
    }
    @Test
    public void testBasicOrderDescription(){
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        //When
        String description = order.getDescription();
        //Then
        assertEquals("Basic pizza", description);
    }
    @Test
    public void testBasicOrderExtracheesePrice(){
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        order = new ExtraCheeseDecorator(order);
        //When
        BigDecimal price = order.getCost();
        //Then
        assertEquals(new BigDecimal(12.5), price);
    }
    @Test
    public void testBasicOrderExtracheeseDescription(){
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        order = new ExtraCheeseDecorator(order);
        //When
        String description = order.getDescription();
        //Then
        assertEquals("Basic pizza + extra cheese", description);
    }
    @Test
    public void testBasicOrderExtracheeseMushroomsHamPrice(){
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        order = new ExtraCheeseDecorator(order);
        order = new MushroomsDecorator(order);
        order = new HamDecorator(order);
        //When
        BigDecimal price = order.getCost();
        //Then
        assertEquals(new BigDecimal(21.5), price);
    }
    @Test
    public void testBasicOrderExtracheeseMushroomsHamDescription(){
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        order = new ExtraCheeseDecorator(order);
        order = new MushroomsDecorator(order);
        order = new HamDecorator(order);
        //When
        String description = order.getDescription();
        //Then
        assertEquals("Basic pizza + extra cheese + mushrooms + ham", description);
    }
}
