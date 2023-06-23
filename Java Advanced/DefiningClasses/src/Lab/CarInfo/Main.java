package Lab.CarInfo;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Car[] cars = new Car[n];

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");

            Car car = tokens.length == 1 ?
                    new Car(tokens[0]) :
                    new Car(tokens[0], tokens[1], Integer.parseInt(tokens[2]));

            cars[i] = car;
        }
        Arrays.stream(cars).forEach(car -> System.out.println(car.carInfo()));
    }
}
