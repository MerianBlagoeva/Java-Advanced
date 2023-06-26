package Exercises.equalityLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        TreeSet<Person> sortedPeople = new TreeSet<>();
        HashSet<Person> people = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().split(" ");

            Person person = new Person(data[0],Integer.parseInt(data[1]) );
            sortedPeople.add(person);
            people.add(person);
        }
        System.out.println(sortedPeople.size());
        System.out.println(people.size());
    }
}
