package DataStructuresExamExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class KAT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line1 = sc.nextLine();
        String line2 = sc.nextLine();

        ArrayDeque<Integer> licensePlates = new ArrayDeque<>(); //queue
        ArrayDeque<Integer> cars = new ArrayDeque<>(); //stack

        Arrays.stream(line1.split(", "))
                .map(Integer::parseInt)
                .forEach(licensePlates::offer);

        Arrays.stream(line2.split(", "))
                .map(Integer::parseInt)
                .forEach(cars::push);

        int registeredCars = 0;
        int days = 0;

        while (!licensePlates.isEmpty() && !cars.isEmpty()) {
            days++;

            int numberOfLicensePlates = licensePlates.poll();
            int numberOfCars = cars.pop();

            if (numberOfLicensePlates / 2 >= numberOfCars) {
                int leftLicensePlates = numberOfLicensePlates - numberOfCars * 2;
                if (leftLicensePlates != 0)
                    licensePlates.offer(leftLicensePlates);
                registeredCars += numberOfCars;
            } else {
                int leftCars = numberOfCars - (numberOfLicensePlates / 2);
                cars.addLast(leftCars);
                registeredCars += numberOfLicensePlates / 2;
            }
        }

        System.out.printf("%d cars were registered for %d days!%n", registeredCars, days);

        if (!licensePlates.isEmpty()) {
            System.out.printf("%d license plates remain!%n", licensePlates.stream().mapToInt(Integer::intValue).sum());
        } else if (!cars.isEmpty()) {
            System.out.printf("%d cars remain without license plates!%n", cars.stream().mapToInt(Integer::intValue).sum());
        } else {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}
