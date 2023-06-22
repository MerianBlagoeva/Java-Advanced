package Exercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Read names and add it to a list
        List<String> guests = Arrays.stream(sc.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        //Read filters and remove deleted filters
        Set<String> filters = new HashSet<>();

        String command = sc.nextLine();

        while (!command.equals("Print")) {
            String[] commandParts = command.split(";");
            String addOrRemove = commandParts[0];
            String type = commandParts[1];
            String parameter = commandParts[2];

            if (addOrRemove.equals("Add filter")) {
                filters.add(type + ";" + parameter);
            } else {
                filters.remove(type + ";" + parameter);
            }
            command = sc.nextLine();
        }

        //Apply filters to the names
        filters.forEach(filter -> {
            Predicate<String> filterToApply = getPredicate(filter);
            guests.removeIf(filterToApply);
        });

        //Print
        guests.forEach(name -> System.out.print(name + " "));
    }

    private static Predicate<String> getPredicate(String filter) {
        String[] filterParts = filter.split(";");
        String filterType = filterParts[0];
        String parameter = filterParts[1];
        switch (filterType) {
            case "Starts with":
                return s -> s.startsWith(parameter);
            case "Ends with":
                return s -> s.endsWith(parameter);
            case "Length":
                try {
                    int length = Integer.parseInt(parameter);
                    return s -> s.length() == length;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException();
                }
            case "Contains":
                return s -> s.contains(parameter);
            default:
                throw new IllegalArgumentException();
        }
    }
}
