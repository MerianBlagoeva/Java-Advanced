package Exercises.trafficLights;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String trafficLightsLine = sc.nextLine();
        String[] trafficLightsAsStrings = trafficLightsLine.split("\\s+");

        TrafficLight[] trafficLights = new TrafficLight[trafficLightsAsStrings.length];
        for (int i = 0; i < trafficLightsAsStrings.length; i++) {
            String s = trafficLightsAsStrings[i];
            TrafficLight.Signal signal = TrafficLight.Signal.valueOf(s);
           trafficLights[i] = new TrafficLight(signal);
        }

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            updateTrafficLights(trafficLights);
            printTrafficLights(trafficLights);
        }
    }

    private static void printTrafficLights(TrafficLight[] trafficLights) {
        for (TrafficLight trafficLight : trafficLights) {
            System.out.print(trafficLight.getSignal() + " ");
        }
        System.out.println();
    }

    private static void updateTrafficLights(TrafficLight[] trafficLights) {
        for (TrafficLight trafficLight : trafficLights) {
            trafficLight.update();
        }
    }
}
