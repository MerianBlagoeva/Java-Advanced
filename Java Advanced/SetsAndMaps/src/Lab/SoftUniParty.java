package Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Set<String> reservations = new TreeSet<>();


        while (!input.equals("PARTY")) {

            reservations.add(input);

            input = sc.nextLine();
        }
        input = sc.nextLine();
        while (!input.equals("END")) {

            reservations.remove(input);

            input = sc.nextLine();
        }
        System.out.println(reservations.size());
        printSet(reservations);

    }

    private static void printSet(Set<String> vip) {
        for (String r : vip) {
            System.out.println(r);
        }
    }
}
