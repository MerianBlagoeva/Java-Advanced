package Lab;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, Map<String, List<String>>> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split(" ");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];


            map.putIfAbsent(continent, new LinkedHashMap<>());
            map.get(continent).putIfAbsent(country, new ArrayList<>());
            map.get(continent).get(country).add(city);
        }
//        for (Map.Entry<String, Map<String, List<String>>> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + ":");
//            map.get(entry.getKey()).forEach((key, value) -> System.out.println((key) + " -> " + String.join(", ", value)));
//        }
        map.forEach((key, value) -> {
            System.out.println(key + ":");
            value.forEach((key1, value1) -> {
                String cities = String.join(", ", value1);
                System.out.println(key1 + " -> " + cities);
            });
        });
    }
}
