package DataStructuresExamExercises;

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Map<Integer, Integer> valuesCounts = new HashMap<>();
        Map<Integer, String> valuesCakes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            String cake = tokens[0];
            int valueNeeded = Integer.parseInt(tokens[1]);
            valuesCakes.put(valueNeeded, cake);
            valuesCounts.put(valueNeeded, 0);
        }

        String line1 = sc.nextLine();
        String line2 = sc.nextLine();

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        Arrays.stream(line1.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(liquids::offer);

        Arrays.stream(line2.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredients::push);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int currLiquid = liquids.poll();
            int currIngredient = ingredients.pop();

            int sum = currLiquid + currIngredient;

            if (valuesCounts.containsKey(sum)) {
                valuesCounts.put(sum, valuesCounts.get(sum) + 1);
            }
        }

        boolean areAllCakesMade = valuesCounts.entrySet().stream().allMatch(e -> e.getValue() != 0);
        String firstOutputLine = areAllCakesMade ?
                "Great! You succeeded in cooking all the food!" :
                "What a pity! You didn't have enough materials to cook everything.";

        String secondOutputLine = liquids.isEmpty() ?
                "Liquids left: none" :
                "Liquids left: " + liquids.stream().map(String::valueOf).collect(Collectors.joining(", "));

        String thirdOutputLine = ingredients.isEmpty() ?
                "Ingredients left: none" :
                "Ingredients left: " + ingredients.stream().map(String::valueOf).collect(Collectors.joining(", "));

        System.out.println(firstOutputLine);
        System.out.println(secondOutputLine);
        System.out.println(thirdOutputLine);

        valuesCakes.forEach((key, value) -> {
            System.out.println(value + ": " + valuesCounts.get(key));
        });
    }
}
