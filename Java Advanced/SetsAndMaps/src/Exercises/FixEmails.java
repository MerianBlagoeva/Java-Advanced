package Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Map<String, String> emails = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            String email = sc.nextLine();
            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                emails.put(input, email);
            }

            input = sc.nextLine();
        }

        emails.forEach((key, value) -> System.out.printf("%s -> %s%n", key, value));
    }
}
