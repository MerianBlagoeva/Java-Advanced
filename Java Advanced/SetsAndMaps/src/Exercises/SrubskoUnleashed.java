package Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrubskoUnleashed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String regex = "(?<singer>[A-Za-z ]+) @(?<venue>[A-Za-z ]+) (?<ticketPrice>\\d+) (?<ticketCount>\\d+)";
        Pattern pattern = Pattern.compile(regex);

        Map<String, LinkedHashMap<String, Integer>> venuesSingersProfits = new LinkedHashMap<>();

        while (!input.equals("End")) {
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String singer = matcher.group("singer");
                String venue = matcher.group("venue");
                int ticketPrice = Integer.parseInt(matcher.group("ticketPrice"));
                int ticketCount = Integer.parseInt(matcher.group("ticketCount"));
                
                venuesSingersProfits.putIfAbsent(venue, new LinkedHashMap<>());
                venuesSingersProfits.get(venue).putIfAbsent(singer, 0);
                int currentProfit = venuesSingersProfits.get(venue).get(singer);
                venuesSingersProfits.get(venue).put(singer, currentProfit + (ticketPrice * ticketCount));
            }

            input = sc.nextLine();
        }
        venuesSingersProfits.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet().stream().sorted((s1, s2) -> s2.getValue() - s1.getValue())
                    .forEach(entry -> System.out.printf("#  %s -> %d%n", entry.getKey(), entry.getValue()));
        });
    }
}
