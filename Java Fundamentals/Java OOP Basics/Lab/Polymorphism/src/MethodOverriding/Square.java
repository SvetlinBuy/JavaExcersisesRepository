package MethodOverriding;

public class Square extends Rectangle{


    public Square(double sideA) {
        super(sideA);
    }

    @Override
    public Double area() {
        return this.sideA * this.sideA;
    }
}
