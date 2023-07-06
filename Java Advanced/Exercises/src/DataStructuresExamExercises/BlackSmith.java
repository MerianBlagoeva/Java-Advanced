package DataStructuresExamExercises;

import java.util.*;
import java.util.stream.Collectors;

public class BlackSmith {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line1 = sc.nextLine();
        String line2 = sc.nextLine();

        ArrayDeque<Integer> steel = new ArrayDeque<>();
        ArrayDeque<Integer> carbon = new ArrayDeque<>();

        Arrays.stream(line1.split("\\s+"))
                .map(Integer::parseInt).forEach(steel::offer);

        Arrays.stream(line2.split("\\s+"))
                .map(Integer::parseInt).forEach(carbon::push);

        Map<String, Integer> swords = new TreeMap<>();

        swords.put("Gladius", 0);
        swords.put("Sabre", 0);
        swords.put("Katana", 0);
        swords.put("Shamshir", 0);

        while (!steel.isEmpty() && !carbon.isEmpty()) {
            int firstSteel = steel.poll();
            int firstCarbon = carbon.pop();
            if (firstCarbon + firstSteel == 70) {
                swords.put("Gladius", swords.get("Gladius") + 1);
            } else if (firstCarbon + firstSteel == 80) {
                swords.put("Shamshir", swords.get("Shamshir") + 1);
            } else if (firstCarbon + firstSteel == 90) {
                swords.put("Katana", swords.get("Katana") + 1);
            } else if (firstCarbon + firstSteel == 110) {
                swords.put("Sabre", swords.get("Sabre") + 1);
            } else {
                carbon.push(firstCarbon + 5);
            }
        }
        int sum = swords.values().stream().mapToInt(Integer::intValue).sum();

        if (sum != 0) {
            System.out.printf("You have forged %d swords.%n", sum);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
        if (steel.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            String collect = steel.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Steel left: " + collect);
        }
        if (carbon.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            String collect = carbon.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Carbon left: " + collect);
        }

        swords.entrySet().stream().filter(e -> e.getValue() != 0)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
