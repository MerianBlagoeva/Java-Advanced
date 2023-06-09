package Exercises;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] setSizes = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        addElements(firstSet, setSizes[0], sc);
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();
        addElements(secondSet, setSizes[1], sc);

        firstSet.retainAll(secondSet);
        printElements(firstSet);
    }

    private static void printElements(LinkedHashSet<Integer> set) {
        for (int element : set) {
            System.out.print(element + " ");
        }
    }

    private static void addElements(LinkedHashSet<Integer> set, int size, Scanner sc) {
        for (int i = 0; i < size; i++) {
            int element = Integer.parseInt(sc.nextLine());
            set.add(element);
        }
    }
}
