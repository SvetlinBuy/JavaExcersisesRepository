package Shapes;

import java.util.Map;

public class Circle extends Shape{

    private  double radius ;

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(double radius ) {

        this.setRadius(radius );
        this.calculatePerimeter();
        this.calculateArea();
    }


    public final double getRadius() {
        return radius;
    }

    @Override
    protected void calculatePerimeter() {


        this.setPerimeter(2 * Math.PI * radius);

    }

    @Override
    protected void calculateArea() {

        this.setArea(Math.PI * Math.pow(radius, 2));

    }
}
