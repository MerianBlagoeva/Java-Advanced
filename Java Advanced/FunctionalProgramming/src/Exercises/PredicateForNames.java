package Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
        Write a predicate. Its goal is to check a name for its length and to return true if the length of the name is less or equal to the passed integer.
        You will be given an integer that represents the length you have to use. On the second line, you will be given a string array with some names.
        Print the names, passing the condition in the predicate.
         */

        int length = Integer.parseInt(sc.nextLine());
        String[] names = sc.nextLine().split("\\s+");

        Predicate<String> checkNameLength = name -> name.length() <= length;

        Arrays.stream(names).filter(checkNameLength).forEach(System.out::println);
    }
}
