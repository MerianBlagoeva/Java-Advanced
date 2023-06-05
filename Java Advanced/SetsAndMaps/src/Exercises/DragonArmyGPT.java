package Exercises;

import java.util.*;

public class DragonArmyGPT { //50/100
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, TreeMap<String, int[]>> dragons = new LinkedHashMap<>();
        Map<String, double[]> averageStats = new LinkedHashMap<>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String dragonType = input[0];
            String dragonName = input[1];
            int damage = input[2].equals("null") ? 45 : Integer.parseInt(input[2]);
            int health = input[3].equals("null") ? 250 : Integer.parseInt(input[3]);
            int armor = input[4].equals("null") ? 10 : Integer.parseInt(input[4]);

            if (!dragons.containsKey(dragonType)) {
                dragons.put(dragonType, new TreeMap<>());
                averageStats.put(dragonType, new double[]{damage, health, armor});
            } else {
                averageStats.get(dragonType)[0] += damage;
                averageStats.get(dragonType)[1] += health;
                averageStats.get(dragonType)[2] += armor;
            }
            dragons.get(dragonType).put(dragonName, new int[]{damage, health, armor});
        }

        for (Map.Entry<String, double[]> type : averageStats.entrySet()) {
            type.getValue()[0] /= dragons.get(type.getKey()).size();
            type.getValue()[1] /= dragons.get(type.getKey()).size();
            type.getValue()[2] /= dragons.get(type.getKey()).size();
        }

        for (Map.Entry<String, TreeMap<String, int[]>> entry : dragons.entrySet()) {
            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", entry.getKey(), averageStats.get(entry.getKey())[0], averageStats.get(entry.getKey())[1], averageStats.get(entry.getKey())[2]);
            for (Map.Entry<String, int[]> dragon : entry.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n", dragon.getKey(), dragon.getValue()[0], dragon.getValue()[1], dragon.getValue()[2]);
            }
        }
    }
}
