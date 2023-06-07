package Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class LogsAggregator {
    public static void main(String[] args) { // 80/100 ??
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, UserInfo> users = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] tokens = input.split("\\s");
            String ip = tokens[0];
            String user = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            users.putIfAbsent(user, new UserInfo());
            users.get(user).ips.add(ip);
            users.get(user).duration += duration;
        }

        for (Map.Entry<String, UserInfo> entry : users.entrySet()) {
            UserInfo user = entry.getValue();
            System.out.println(entry.getKey() + ": " + user.duration + " [" + String.join(", ", user.ips) + "]");
        }
    }

    static class UserInfo {
        TreeSet<String> ips = new TreeSet<>();
        int duration;
    }
}
