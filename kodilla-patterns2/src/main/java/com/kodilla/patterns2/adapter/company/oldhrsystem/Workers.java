package com.kodilla.patterns2.adapter.company.oldhrsystem;

public class Workers {
    private String[][] workers = {
            {"67032906720", "John", "Smith"},
            {"59051600233", "Ivone", "Novak"},
            {"75101300460", "Jessie", "Pinkman"},
            {"75121300255", "Walter", "White"},
            {"75051600345", "Clara", "Lanson"}
    };
    private double[] salaries = {
            4500.00,
            3700.00,
            4350.00,
            9000.00,
            6200.00
    };

    public String[][] getWorkers() {
        return workers;
    }

    public double[] getSalaries() {
        return salaries;
    }
}
