package DataStructuresExamExercises;

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop {
    private enum Food {
        BISCUIT(25),
        CAKE(50),
        PASTRY(75),
        PIE(100);

        public final int valueNeeded;

        Food(int valueNeeded) {
            this.valueNeeded = valueNeeded;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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


        int biscuitCount = 0;
        int cakeCount = 0;
        int pastryCount = 0;
        int pieCount = 0;

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int currLiquid = liquids.poll();
            int currIngredient = ingredients.pop();

            int sum = currLiquid + currIngredient;
            if (sum == Food.BISCUIT.valueNeeded) {
                biscuitCount++;
            } else if (sum == Food.CAKE.valueNeeded) {
                cakeCount++;
            } else if (sum == Food.PASTRY.valueNeeded) {
                pastryCount++;
            } else if (sum == Food.PIE.valueNeeded) {
                pieCount++;
            } else {
                ingredients.push(currIngredient + 3);
            }
        }

        String firstOutputLine = biscuitCount >= 1 && cakeCount >= 1 && pastryCount >= 1 && pieCount >= 1 ?
                "Great! You succeeded in cooking all the food!" :
                "What a pity! You didn't have enough materials to cook everything.";

        String secondOutputLine = liquids.isEmpty() ?
                "Liquids left: none" :
                "Liquids left: " + liquids.stream().map(String::valueOf).collect(Collectors.joining(", "));

        String thirdOutputLine = ingredients.isEmpty() ?
                "Ingredients left: none" :
                "Ingredients left: " + ingredients.stream().map(String::valueOf).collect(Collectors.joining(", "));

        String lastOutputLine = "Biscuit: " + biscuitCount + System.lineSeparator() +
                                "Cake: " + cakeCount + System.lineSeparator() +
                                "Pie: " + pieCount + System.lineSeparator() +
                                "Pastry: " + pastryCount;

        System.out.println(firstOutputLine);
        System.out.println(secondOutputLine);
        System.out.println(thirdOutputLine);
        System.out.println(lastOutputLine);
    }
}
