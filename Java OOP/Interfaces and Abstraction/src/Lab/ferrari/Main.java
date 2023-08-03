package Lab.ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String driverName = sc.nextLine();

        Car car = new Ferrari(driverName);

        System.out.println(car);
    }
}
