package Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> getMin = arr -> {
            int min = Integer.MAX_VALUE;
            for (int number : arr) {
                if (number < min) {
                    min = number;
                }
            }
            return min;
        };

        int min = getMin.apply(numbers);

//        int min = Arrays.stream(numbers).min().orElse(-1);
//        Function<int[], Integer> minFunction = elements -> Collections.min(Arrays.stream(elements).boxed().collect(Collectors.toList()));
        System.out.println(min);


    }
}
