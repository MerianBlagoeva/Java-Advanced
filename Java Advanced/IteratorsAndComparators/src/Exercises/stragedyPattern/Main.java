package Exercises.stragedyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        TreeSet<Person> nameSet = new TreeSet<>(new PersonNameComparator());
        TreeSet<Person> ageSet = new TreeSet<>(new PersonAgeComparator());

        for (int i = 0; i < n; i++) {
            String[] personData = sc.nextLine().split(" ");
            String name = personData[0];
            int age = Integer.parseInt(personData[1]);

            Person person = new Person(name, age);
            nameSet.add(person);
            ageSet.add(person);
        }

        nameSet.forEach(System.out::println);
        ageSet.forEach(System.out::println);
    }
}
