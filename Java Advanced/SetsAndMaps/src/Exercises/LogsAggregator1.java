package Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 100/100...

        int n = Integer.parseInt(sc.nextLine());
        Map<String, TreeMap<String, Integer>> users = new TreeMap<>();
        Map<String, Integer> durations = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split(" ");
            String ip = tokens[0];
            String user = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            users.putIfAbsent(user, new TreeMap<>());
            users.get(user).put(ip, 0);
            durations.putIfAbsent(user, 0);
            durations.put(user, durations.get(user) + duration);
        }
        durations.forEach((key, value) -> {
            System.out.print(key + ": " + value + " ");
            var output = users.get(key).keySet();
            System.out.println("[" + String.join(", ", output) + "]");
        });
    }
}
