package Exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Map<String, String> phonebook = new HashMap<>();

        while (!input.equals("search")) {
            String[] tokens = input.split("-");
            phonebook.put(tokens[0], tokens[1]);

            input = sc.nextLine();
        }

        input = sc.nextLine();

        while (!input.equals("stop")) {
            String output = phonebook.containsKey(input) ? String.format("%s -> %s", input, phonebook.get(input)) : String.format("Contact %s does not exist.", input);
            System.out.println(output);

            input = sc.nextLine();
        }
    }
}
