package Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int endOfRange = Integer.parseInt(sc.nextLine());

        List<Integer> divisors = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Predicate<Integer> isDivisible = number -> {
            for (Integer divisor : divisors) {
                if (number % divisor != 0) {
                    return false;
                }
            }
            return true;
        };

        IntStream.rangeClosed(1, endOfRange)
                .boxed()
                .filter(isDivisible)
                .forEach(number -> System.out.print(number + " "));
    }
}
