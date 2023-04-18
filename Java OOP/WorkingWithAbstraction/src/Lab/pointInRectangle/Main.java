package Lab.pointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] rectanglePoints = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Point bottomLeft = new Point(rectanglePoints[0], rectanglePoints[1]);
        Point topRight = new Point(rectanglePoints[2], rectanglePoints[3]);

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int pointsCount = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < pointsCount; i++) {
            Point current = PointUtil.parsePoint(sc.nextLine());

            System.out.println(rectangle.contains(current));
        }
    }
}
