package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {
    private static int shapeCounter = 0;
    ArrayList<Shape> shapes = new ArrayList<>();

    public ShapeCollector() {}

        public void addFigure(Shape shape){
            //nothing
            shapes.add(shape);
        }
        public boolean removeFigure(Shape shape){
            //do nothing
            boolean result = false;
            if(shapes.contains(shape)){
                shapes.remove(shape);
                result = true;
            }
            return result;
        }
        public Shape getFigure( int n){
            Shape shape = null;
            if(n >= 0 && n < shapes.size()){
                shape = shapes.get(n);
            }
            return shape;
        }
        public void showFigures () {
            //Nothing
            for(Shape shape:shapes){
                System.out.println(shape.toString());
            }
        }
        public int getShapesQuantity() {
            return this.shapes.size();
        }
    }

