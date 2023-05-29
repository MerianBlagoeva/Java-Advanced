package Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        Set<String> cars = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] info = input.split(", ");
            String command = info[0];
            String registration = info[1];

            if (command.equals("IN")) {
                cars.add(registration);
            } else {
                cars.remove(registration);
            }
            input = sc.nextLine();
        }
        String output = cars.isEmpty() ? "Parking Lot is Empty" : String.join(System.lineSeparator(), cars);

        System.out.println(output);
    }
}
