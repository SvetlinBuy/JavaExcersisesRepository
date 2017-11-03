package ClassBoxDataValidation;

public class Box {

    private void setLength(Double length) {

        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(Double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(Double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    private Double length;
    private Double width;
    private Double height;

    public Box(Double length, Double width, Double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public Double surfaceArea() {

        Double surfaceArea = (2 * length * width)
                + (2 * length * height)
                + (2 * width * height);

        return surfaceArea;
    }

    public Double lateralSurfaceArea() {

        Double lateralSurfaceArea = (2 * length * height) + (2 * width * height);

        return lateralSurfaceArea;
    }

    public Double volume() {

        Double Volume = length * width * height;

        return Volume;
    }
}
