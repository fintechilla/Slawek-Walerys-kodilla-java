package com.kodilla.patterns.builder.bigmac;

public enum Bun {
    SEZAME("sezame"),NOSEZAME("nosezame");
    private String value;

    Bun(String value) {
        this.value = value;
    }
    String getValue(){
        return value;
    }
}
