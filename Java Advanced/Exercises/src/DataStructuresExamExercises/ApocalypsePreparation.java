package DataStructuresExamExercises;

import java.util.*;
import java.util.stream.Collectors;

public class ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line1 = sc.nextLine();
        String line2 = sc.nextLine();

        Map<String, Integer> createdItems = new HashMap<>();
        createdItems.put("Patch", 0);
        createdItems.put("Bandage", 0);
        createdItems.put("MedKit", 0);

        ArrayDeque<Integer> textiles = new ArrayDeque<>();
        ArrayDeque<Integer> medicaments = new ArrayDeque<>();

        Arrays.stream(line1.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(textiles::offer);

        Arrays.stream(line2.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(medicaments::push);

        while (!textiles.isEmpty() && !medicaments.isEmpty()) {
            int currTextile = textiles.poll();
            int currMedicament = medicaments.pop();

            int sum = currTextile + currMedicament;

            if (sum == 30) {
                createdItems.put("Patch", createdItems.get("Patch") + 1);
            } else if (sum == 40) {
                createdItems.put("Bandage", createdItems.get("Bandage") + 1);
            } else if (sum == 100) {
                createdItems.put("MedKit", createdItems.get("MedKit") + 1);
            } else if (sum > 100) {
                createdItems.put("MedKit", createdItems.get("MedKit") + 1);
                medicaments.push(medicaments.pop() + sum - 100);
            } else {
                medicaments.push(currMedicament + 10);
            }
        }

        if (textiles.isEmpty() && medicaments.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textiles.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else {
            System.out.println("Medicaments are empty.");
        }

        createdItems.entrySet().stream()
                .filter(e -> e.getValue() != 0)
                .sorted(Map.Entry.comparingByKey())
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));

        if (!medicaments.isEmpty()) {
            System.out.println("Medicaments left: " + medicaments.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (!textiles.isEmpty()) {
            System.out.println("Textiles left: " + textiles.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        }
    }
}
