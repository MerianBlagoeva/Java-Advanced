package DataStructuresExamExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line1 = sc.nextLine();
        String line2 = sc.nextLine();

        ArrayDeque<Integer> caffeine = new ArrayDeque<>(); //stack
        ArrayDeque<Integer> energyDrinks = new ArrayDeque<>(); //queue

        Arrays.stream(line1.split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(caffeine::push);

        Arrays.stream(line2.split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(energyDrinks::offer);

        int totalCaffeine = 0;

        while (!caffeine.isEmpty() && !energyDrinks.isEmpty()) {
            int currentMilligrams = caffeine.pop();
            int currentEnergyDrink = energyDrinks.poll();

            int currentCaffeine = currentMilligrams * currentEnergyDrink;
            if (currentCaffeine + totalCaffeine <= 300) {
                totalCaffeine += currentCaffeine;
            } else {
                energyDrinks.offer(currentEnergyDrink);
                if (totalCaffeine - 30 >= 0) {
                    totalCaffeine -= 30;
                } else {
                    totalCaffeine = 0;
                }
            }
        }

        if (!energyDrinks.isEmpty()) {
            String output = energyDrinks.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Drinks left: " + output);
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.%n", totalCaffeine);
    }
}
