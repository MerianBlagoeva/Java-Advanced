package Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfNames = Integer.parseInt(sc.nextLine());

        Set<String> names = new LinkedHashSet<>();
        while (numberOfNames-- > 0) {
            String name = sc.nextLine();
            names.add(name);
        }
        names.forEach(System.out::println);
    }
}
