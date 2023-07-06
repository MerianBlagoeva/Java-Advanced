package DataStructuresExamExercises;

import java.util.*;

public class ItsChocolateTIme {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line1 = sc.nextLine();
        String line2 = sc.nextLine();

        Map<String, Integer> chocolates = new TreeMap<>();
        chocolates.put("Milk Chocolate", 0);
        chocolates.put("Dark Chocolate", 0);
        chocolates.put("Baking Chocolate", 0);

        ArrayDeque<Double> milk = new ArrayDeque<>();
        ArrayDeque<Double> cocoa = new ArrayDeque<>();

        Arrays.stream(line1.split("\\s+"))
                .map(Double::parseDouble)
                .forEach(milk::offer);

        Arrays.stream(line2.split("\\s+"))
                .map(Double::parseDouble)
                .forEach(cocoa::push);

        while (!milk.isEmpty() && !cocoa.isEmpty()) {
            double currentMilkQuantity = milk.poll();
            double currentCocoaValue = cocoa.pop();

            double cocoaPercentage = currentCocoaValue / (currentCocoaValue + currentMilkQuantity) * 100;

            if (cocoaPercentage == 30) {
                chocolates.put("Milk Chocolate", chocolates.get("Milk Chocolate") + 1);
            } else if (cocoaPercentage == 50) {
                chocolates.put("Dark Chocolate", chocolates.get("Dark Chocolate") + 1);
            } else if (cocoaPercentage == 100) {
                chocolates.put("Baking Chocolate", chocolates.get("Baking Chocolate") + 1);
            } else {
                milk.offer(currentMilkQuantity + 10);
            }
        }

        boolean areAllChocolatesMade = chocolates.entrySet().stream()
                                               .allMatch(e -> e.getValue() != 0);

        if (areAllChocolatesMade) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        chocolates.entrySet().stream()
                .filter(e -> e.getValue() != 0)
                .forEach(e -> System.out.printf("# %s --> %d%n", e.getKey(), e.getValue()));
    }
}
