package Exercises.vehicles;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static final String CAR_NAME = "Car";
    public static final String TRUCK_NAME = "Truck";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] carInfo = sc.nextLine().split("\\s+");
        String[] truckInfo = sc.nextLine().split("\\s+");

        Map<String, Vehicle> vehiclesByType = new LinkedHashMap<>();
        vehiclesByType.put(CAR_NAME, new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2])));
        vehiclesByType.put(TRUCK_NAME, new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2])));

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commandParts = sc.nextLine().split("\\s+");
            String operation = commandParts[0];
            String vehicleType = commandParts[1];
            Vehicle vehicle = vehiclesByType.get(vehicleType);
            double parameter = Double.parseDouble(commandParts[2]);

            switch (operation) {
                case "Drive":
                    String output = vehicle.drive(parameter) ? vehicleType + " travelled " + new DecimalFormat("#.##").format(parameter) + " km" : vehicleType + " needs refueling";
                    System.out.println(output);
                    break;
                case "Refuel":
                    vehicle.refuel(parameter);
                    break;
            }
        }

        System.out.printf("Car: %.2f%n", vehiclesByType.get(CAR_NAME).getFuelQuantity());
        System.out.printf("Truck: %.2f", vehiclesByType.get(TRUCK_NAME).getFuelQuantity());
    }
}
