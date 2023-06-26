package Exercises.comparingObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        List<Person> people = new ArrayList<>();

        while (!input.equals("END")) {
            String[] info = input.split("\\s+");
            Person person = new Person(info[0], Integer.parseInt(info[1]), info[2]);

            people.add(person);
            input = sc.nextLine();
        }

        int nthPersonIndex = Integer.parseInt(sc.nextLine());

        Person nthPerson = people.get(nthPersonIndex - 1);

        long countOfEqualPeople = people.stream()
                .filter(p -> p.compareTo(nthPerson) == 0)
                .count();

        System.out.println(countOfEqualPeople == 1
                ? "No matches"
                : countOfEqualPeople + " "
                  + (people.size() - countOfEqualPeople)
                  + " "
                  + people.size());
    }
}
