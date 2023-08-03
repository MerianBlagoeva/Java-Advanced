package Lab.p03_LiskovSubstitution.p01_Square;

public class Main {
    public static void main(String[] args) {

        Shape rectangle = new Rectangle(13, 2);
        Shape square = new Square(2);

        printShapeArea(rectangle);
        printShapeArea(square);
    }

    private static void printShapeArea(Shape shape) {
        System.out.println(shape.getArea());
    }
}
