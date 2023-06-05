package Exercises;

import java.util.*;

public class DragonArmy {
    public static void main(String[] args) { //50/100
        Scanner sc = new Scanner(System.in);
        Map<String, TreeMap<String, List<String>>> dragons = new LinkedHashMap<>();
        Map<String, List<Double>> averageStats = new LinkedHashMap<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split(" ");
            String type = tokens[0];
            String name = tokens[1];
            String damage = tokens[2];
            String health = tokens[3];
            String armor = tokens[4];
            dragons.putIfAbsent(type, new TreeMap<>());
            dragons.get(type).putIfAbsent(name, new ArrayList<>());
            if (damage.equals("null")) {
                damage = "45";
            }
            if (health.equals("null")) {
                health = "250";
            }
            if (armor.equals("null")) {
                armor = "10";
            }
            averageStats.putIfAbsent(type, new ArrayList<>());
            averageStats.get(type).add(Double.parseDouble(damage));
            averageStats.get(type).add(Double.parseDouble(health));
            averageStats.get(type).add(Double.parseDouble(armor));

            dragons.get(type).get(name).add(damage);
            dragons.get(type).get(name).add(health);
            dragons.get(type).get(name).add(armor);

        }


        Map<String, List<Double>> finalAverageMap = new LinkedHashMap<>();
        averageStats.forEach((key, value) -> {
            int sumDamage = 0;
            int sumHealth = 0;
            int sumArmor = 0;
            for (int i = 0; i < value.size(); i+= 3) {
                sumDamage += value.get(i);
                sumHealth += value.get(i + 1);
                sumArmor += value.get(i + 2);
            }
            double avgDamage = 1.0 * sumDamage / (1.0  *value.size() / 3);
            double avgHealth = 1.0 * sumHealth / (1.0  *value.size() / 3);
            double avgArmor = 1.0 * sumArmor / (1.0  *value.size() / 3);
            finalAverageMap.putIfAbsent(key, new ArrayList<>());
            finalAverageMap.get(key).add(avgDamage);
            finalAverageMap.get(key).add(avgHealth);
            finalAverageMap.get(key).add(avgArmor);

        });
        dragons.forEach((key, value) -> {
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", key, finalAverageMap.get(key).get(0), finalAverageMap.get(key).get(1), finalAverageMap.get(key).get(2));
            value.forEach((name, stats) -> {
                System.out.printf("-%s -> ", name);
                System.out.printf("damage: %s, health: %s, armor: %s%n", stats.get(0),
                        stats.get(1), stats.get(2));
            });
        });

    }
}
