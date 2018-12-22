package com.kodilla.patterns.builder.pizza;

import org.junit.Assert;
import org.junit.Test;

public class pizzaTestSuite {
    @Test
    public void testPizzaNew() {
        //Given
        Pizza pizza = new Pizza.PizzaBuilder()
                .ingredient("Onion")
                .bottom("Thin")
                .sauce("Spicy")
                .ingredient("Ham")
                .ingredient("Mushrooms")
                .build();
        System.out.println(pizza.toString());
        //When
        int howManyIngredients = pizza.getIngredients().size();
        System.out.println(howManyIngredients);
        //Then
        Assert.assertEquals(3, howManyIngredients);
    }
}
