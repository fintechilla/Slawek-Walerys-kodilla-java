package com.kodilla.good.patterns.food2Door;

public class User {
    private String name;
    private String lastName;
    private int id;

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }
}
