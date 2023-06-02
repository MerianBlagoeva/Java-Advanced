package Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Map<Character, Integer> occurrences = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            occurrences.putIfAbsent(input.charAt(i), 0);
            occurrences.put(input.charAt(i), occurrences.get(input.charAt(i)) + 1);
        }
        occurrences.forEach((key, value) -> System.out.printf("%c: %d time/s%n", key, value));
    }
}
