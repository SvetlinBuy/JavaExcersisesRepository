package ClassBox;

public class Box {

    private Double lenght;
    private Double width;
    private Double height;

    public Box(Double lenght, Double width, Double height) {
        this.lenght = lenght;
        this.width = width;
        this.height = height;
    }

    public Double surfaceArea() {

        Double surfaceArea = (2 * lenght * width)
                + (2 * lenght * height)
                + (2 * width * height);

        return surfaceArea;
    }

    public Double lateralSurfaceArea() {

        Double lateralSurfaceArea = (2 * lenght * height) + (2 * width * height);

        return lateralSurfaceArea;
    }

    public Double volume() {

        Double Volume = lenght * width * height;

        return Volume;
    }
}
