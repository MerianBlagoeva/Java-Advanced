package Exercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> guests = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());

        List<String> guestsToRemove = new ArrayList<>();

        String command = sc.nextLine();
        while (!command.equals("Party!")) {
            String[] commandParts = command.split("\\s+");
            String action = commandParts[0]; //double or remove
            String type = commandParts[1];
            String parameter = commandParts[2];

            Predicate<String> appliesToCriteria = getPredicate(type, parameter);

            switch (action) {
                case "Remove":
                    guests.forEach(guest -> {
                        if (appliesToCriteria.test(guest)) {
                            guestsToRemove.add(guest);
                        }
                    });
                    break;

                case "Double":
                    List<String> guestsToDouble = guests.stream()
                            .filter(appliesToCriteria)
                            .collect(Collectors.toList());

                    guests.addAll(guestsToDouble);
                    break;
            }
            command = sc.nextLine();
        }

        guests.removeAll(guestsToRemove);
        Collections.sort(guests);

        if (!guests.isEmpty()) {
            System.out.printf(String.join(", ", guests) + " are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }

    private static Predicate<String> getPredicate(String type, String parameter) {
        switch (type) {
            case "StartsWith":
                return name -> name.startsWith(parameter);
            case "EndsWith":
                return name -> name.endsWith(parameter);
            case "Length":
                return name -> name.length() == Integer.parseInt(parameter);
            default:
                throw new IllegalArgumentException();
        }
    }


}
