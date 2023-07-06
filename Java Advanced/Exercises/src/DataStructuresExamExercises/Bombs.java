package DataStructuresExamExercises;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line1 = sc.nextLine();
        String line2 = sc.nextLine();

        ArrayDeque<Integer> effects = new ArrayDeque<>();
        ArrayDeque<Integer> casings = new ArrayDeque<>();

        Arrays.stream(line1.split(", "))
                .map(Integer::parseInt)
                .forEach(effects::offer);

        Arrays.stream(line2.split(", "))
                .map(Integer::parseInt)
                .forEach(casings::push);

        Map<String, Integer> bombs = new TreeMap<>();
        bombs.put("Datura Bombs", 0);
        bombs.put("Cherry Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);


        while (!effects.isEmpty() && !casings.isEmpty()) {

            int currEffect = effects.poll();
            int currCasing = casings.pop();

            int sum = currEffect + currCasing;


            switch (sum) {
                case 40:
                    bombs.put("Datura Bombs", bombs.get("Datura Bombs") + 1);
                    break;
                case 60:
                    bombs.put("Cherry Bombs", bombs.get("Cherry Bombs") + 1);
                    break;
                case 120:
                    bombs.put("Smoke Decoy Bombs", bombs.get("Smoke Decoy Bombs") + 1);
                    break;
                default:
                    casings.push(currCasing - 5);
                    effects.addFirst(currEffect);
            }
            if (bombs.entrySet().stream().allMatch(bomb -> bomb.getValue() >= 3)) {
                break;
            }
        }

        boolean areAllBombsMade = bombs.entrySet().stream().allMatch(bomb -> bomb.getValue() >= 3);

        String outputLine1 = areAllBombsMade ?
                "Bene! You have successfully filled the bomb pouch!" :
                "You don't have enough materials to fill the bomb pouch.";

        String outputLine2 = effects.isEmpty() ?
                "Bomb Effects: empty" :
                "Bomb Effects: " + effects.stream().map(String::valueOf).collect(Collectors.joining(", "));

        String outputLine3 = casings.isEmpty() ?
                "Bomb Casings: empty" :
                "Bomb Casings: " + casings.stream().map(String::valueOf).collect(Collectors.joining(", "));


        System.out.println(outputLine1);
        System.out.println(outputLine2);
        System.out.println(outputLine3);
        bombs.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
