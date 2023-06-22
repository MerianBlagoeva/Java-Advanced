package Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Write a program that reverses a collection and removes elements that are divisible by a given integer n.

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int n = Integer.parseInt(sc.nextLine());
        Collections.reverse(numbers);

//        numbers.stream().filter(number -> number % n != 0)
//                .forEach(number -> System.out.print(number + " "));

        Predicate<Integer> isDivisibleByN = number -> number % n == 0;

        numbers.removeIf(isDivisibleByN);
        numbers.forEach(e -> System.out.print(e + " "));

    }
}
