package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacNew(){
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(Bun.SEZAME)
                .burgers(2)
                .ingredient(Ingredient.BACON)
                .sauce(Sauce.SPICY)
                .ingredient(Ingredient.CHEESE)
                .build();
        System.out.println(bigmac.toString());
        //When
        String bunUsed = bigmac.getBun().getValue();//.toString();
        int numberBurgers = bigmac.getBurgers();
        String sauceUsed = bigmac.getSauce().getValue();//.toString();
        //Then
        Assert.assertEquals("sezame", bunUsed);
        Assert.assertEquals(2, numberBurgers);
        Assert.assertEquals("spicy",  sauceUsed);
    }
}
