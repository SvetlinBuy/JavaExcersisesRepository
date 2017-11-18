package Shapes;

public class Rectangle extends Shape {

    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }


    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(this.height * 2 + this.width * 2);
    }


    @Override
    protected void calculateArea() {
        setArea(this.height * this.width);
    }
}
