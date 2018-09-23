package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";
    public static final String SHOPPING = "SHOPPING";

    public final Task makeTask(final String taskClass){
        switch (taskClass){
            case DRIVING:
                return new DrivingTask("driving","Paris", "Bentley");
            case PAINTING:
                return new PaintingTask("painting", "white", "walls" );
            case SHOPPING:
                return new ShoppingTask("shopping", "onions", 2.0);
            default:
                return null;
        }
    }
}
