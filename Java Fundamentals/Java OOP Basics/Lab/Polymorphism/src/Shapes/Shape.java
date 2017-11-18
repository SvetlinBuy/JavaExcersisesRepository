package Shapes;

public abstract class Shape {

    private  double perimeter;
    private  double area;

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    protected void setArea(Double area) {this.area = area;}

    protected abstract void calculatePerimeter();
    protected abstract void  calculateArea();


    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }
}
