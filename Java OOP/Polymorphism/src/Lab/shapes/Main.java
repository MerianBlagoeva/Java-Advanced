package Lab.shapes;

public class Main {
    public static void main(String[] args) {

        Shape rectangle = new Rectangle(2D, 4D);

        printShape(rectangle);
        printShape(rectangle);
        printShape(rectangle);
        printShape(rectangle);
        printShape(rectangle);
        printShape(rectangle);

    }

    private static void printShape(Shape shape) {

        long begin = System.currentTimeMillis();

        System.out.println(shape.calculatePerimeter());

        long end = System.currentTimeMillis();

        System.out.println("Perimeter time " + (end - begin));

        System.out.println();

        begin = System.currentTimeMillis();

        System.out.println(shape.calculateArea());

        end = System.currentTimeMillis();

        System.out.println("Area time " + (end - begin));

        System.out.println();

    }
}
