package Exercises;

import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int compounds = Integer.parseInt(sc.nextLine());
        Set<String> elements = new TreeSet<>();
        for (int i = 0; i < compounds; i++) {
            String[] compound = sc.nextLine().split("\\s+");
           Collections.addAll(elements, compound);
        }
        System.out.println(String.join(" ", elements));
    }
}
