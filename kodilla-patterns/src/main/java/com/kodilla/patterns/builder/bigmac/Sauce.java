package com.kodilla.patterns.builder.bigmac;

public enum Sauce {
    //standard, 1000 wysp, barbecue
    STANDARD("standard"), ISLANDS("1000Islands"), BBQ("bbq"), SPICY("spicy");
    private String value;
    Sauce(String value){this.value = value;}
    String getValue() {return value;}

}
