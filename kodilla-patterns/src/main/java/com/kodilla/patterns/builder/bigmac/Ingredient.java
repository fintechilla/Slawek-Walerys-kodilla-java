package com.kodilla.patterns.builder.bigmac;

public enum Ingredient {
    BACON("bacon"), ONION("onion"), CHEESE("cheese"), SALAD("salad"), CUCUMBER("cucumber"),
    CHILI("chili"), CHILIPEPPERS("chilipeppers"), MUSHROOM("mushroom"),
    SHRIMP("shrimp");
    private String value;

    Ingredient(String value) {
        this.value = value;
    }
    String getValue(){
        return value;
    }

}
