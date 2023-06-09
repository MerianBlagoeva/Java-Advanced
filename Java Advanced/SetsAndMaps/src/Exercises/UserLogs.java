package Exercises;

import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        Map<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();

        while (!input.equals("end")) {
//            IP=192.23.30.40 message='Hello&derps.' user=destroyer
            String[] inputParts = input.split(" ");
            String userName = inputParts[2].substring(5);
            String ip = inputParts[0].substring(3);

            users.putIfAbsent(userName, new LinkedHashMap<>());
            users.get(userName).putIfAbsent(ip, 0);
            users.get(userName).put(ip, users.get(userName).get(ip) + 1);
            input = sc.nextLine();
        }
        users.forEach((key, value) -> {
            System.out.println(key + ":" + " ");
            StringBuilder sb = new StringBuilder();
            value.forEach((innerKey, innerValue) -> sb.append(String.format("%s => %d, ", innerKey, innerValue)));
            String output = sb.substring(0, sb.length() - 2);
            System.out.println(output + ".");
        });
    }
}
