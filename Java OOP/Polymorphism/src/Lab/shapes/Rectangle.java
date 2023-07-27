package Lab.shapes;

public class Rectangle extends Shape {

    private final Double height;
    private final Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public final Double getHeight() {
        return height;
    }

    public final Double getWidth() {
        return width;
    }

    @Override
    public Double calculatePerimeter() {
        if (perimeter == null) {
            perimeter = getPerimeter();
        }

        return perimeter;
    }

    private double getPerimeter() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) {

        }

        return 2 * height + 2 * width;
    }

    @Override
    public Double calculateArea() {
        return getArea();
    }

    private double getArea() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) {

        }

        return height * width;
    }
}
