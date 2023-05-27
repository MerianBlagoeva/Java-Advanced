package Lab;

import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] numbers = Arrays.stream(sc.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> occurrences = new LinkedHashMap<>();

        for (double num : numbers) {
            occurrences.putIfAbsent(num, 0);
            occurrences.put(num, occurrences.get(num) + 1);
        }

        for (Map.Entry<Double, Integer> entry : occurrences.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
