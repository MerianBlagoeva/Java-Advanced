package Exercises.carSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Map<String, Engine> engineMap = new LinkedHashMap<>();
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().split("\\s+");
            String model = data[0];
            String power = data[1];
            Engine engine = null;

            switch (data.length) {
                case 4 -> {
                    String enginePower = data[2];
                    String efficiency = data[3];
                    engine = new Engine(model, power, enginePower, efficiency);
                }
                case 3 -> {
                    String displacementOrEfficiency = data[2];
                    engine = new Engine(model, power, displacementOrEfficiency);
                }
                case 2 -> engine = new Engine(model, power);
            }
            engineMap.put(model, engine);
        }
        int numberOfCars = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numberOfCars; i++) {
            String[] carData = sc.nextLine().split("\\s+");
            String model = carData[0];
            Engine engine = engineMap.get(carData[1]);

            Car car = null;
            switch (carData.length) {
                case 4 -> {
                    String weight = carData[2];
                    String color = carData[3];
                    car = new Car(model, engine, weight, color);
                }
                case 3 -> {
                    String weightOrColor = carData[2];
                    car = new Car(model, engine, weightOrColor);
                }
                case 2 -> car = new Car(model, engine);
            }
            cars.add(car);
        }
        cars.forEach(System.out::println);
    }
}
