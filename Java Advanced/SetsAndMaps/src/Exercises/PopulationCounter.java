package Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        Map<String, LinkedHashMap<String, Long>> countries = new LinkedHashMap<>();
        Map<String, Long> countriesTotalPopulation = new LinkedHashMap<>();

        while (!input.equals("report")) {
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            if (!countries.containsKey(country)) {
                countries.put(country, new LinkedHashMap<>());
                countriesTotalPopulation.put(country, 0L);
            }
            countriesTotalPopulation.put(country, countriesTotalPopulation.get(country) + population);
            if (!countries.get(country).containsKey(city)) {
                countries.get(country).put(city, population);
            }


            input = sc.nextLine();
        }
        countries.entrySet().stream()
                .sorted((c1, c2) -> countriesTotalPopulation.get(c2.getKey()).compareTo(countriesTotalPopulation.get(c1.getKey())))
                .forEach(country -> {
                    System.out.printf("%s (total population: %d)%n", country.getKey(), countriesTotalPopulation.get(country.getKey()));
                    country.getValue().entrySet()
                            .stream().sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue()))
                            .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
                });
    }
}
