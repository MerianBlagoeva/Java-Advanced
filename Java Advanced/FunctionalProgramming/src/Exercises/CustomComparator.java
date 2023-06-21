package Exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
        Write a custom comparator that sorts all even numbers before all odd ones in ascending order.
        Pass it to an Arrays.sort() function and print the result.
         */

        Integer[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Comparator<Integer> comparator = (first, second) -> {
            if (first % 2 == 0 && second % 2 != 0) {
                return -1;
                //първото е четно
                //второто е нечетно
            } else if (first % 2 != 0 && second % 2 == 0) {
                return 1;
                //първото е нечетно
                //второто е четно
            }
            return first.compareTo(second);
        };

        Arrays.sort(numbers, comparator);
        Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));
    }
}
