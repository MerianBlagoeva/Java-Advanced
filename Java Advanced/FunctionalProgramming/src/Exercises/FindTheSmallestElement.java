package Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
        Write a program that is using a custom function (written by you) to find the smallest integer in a sequence of integers.
        The input could have more than one space. Your task is to collect the integers from the console, find the smallest one and print its index
        (if more than one such elements exist, print the index of the rightmost one).
         */

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> findSmallestIndex = list -> {
            int min = Integer.MAX_VALUE;
            int index = -1;

            for (int i = 0; i < list.size(); i++) {
                Integer number = list.get(i);
                if (number <= min) {
                    min = number;
                    index = i;
                }
            }
            return index;
        };

        Function<List<Integer>, Integer> alternativeFunction = list -> {
            int min = list.stream().min(Integer::compare).get();
            return list.lastIndexOf(min);
        };


//        System.out.println(findSmallestIndex.apply(numbers));
        System.out.println(alternativeFunction.apply(numbers));
    }
}
