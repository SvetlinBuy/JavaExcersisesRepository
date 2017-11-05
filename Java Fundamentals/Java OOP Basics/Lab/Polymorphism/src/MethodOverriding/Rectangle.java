package MethodOverriding;

public class Rectangle {

    protected double sideA;
    private double sideB;

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public Rectangle(double side) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public Double area(){

        return sideA * sideB;

    }
}
