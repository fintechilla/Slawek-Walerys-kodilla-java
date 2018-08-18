package com.kodilla.testing.shape;

interface Shape {
    public String getShapeName();
    public Double getField();
}


class Square implements Shape{
    private String name = "square";
    private Double field;

    public Square(Double field){
        this.field = field;
    }

    public String getShapeName(){
        return this.name;
        }
    public Double getField(){
        return this.field;
        }
}
class Triangle implements Shape{
    private String name = "Triangle";
    private Double field;

    public Triangle(Double field) {
        this.field = field;
    }

    public String getShapeName(){
        return this.name;
    }
    public Double getField(){
        return this.field;
    }
}
class Rectangle implements Shape{
    private String name = "Rectangle";
    private Double field;

    public Rectangle(Double field) {
        this.field = field;
    }

    public String getShapeName(){
        return this.name;
    }
    public Double getField(){
        return this.field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;

        if (!name.equals(rectangle.name)) return false;
        return field.equals(rectangle.field);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + field.hashCode();
        return result;
    }
}


