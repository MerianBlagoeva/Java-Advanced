package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class PrintCommonElementsInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] firstArray = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondArray = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        //TODO: Print the common elements with complexity O(N).
        // The elements are sorted from the beginning
    }
}
