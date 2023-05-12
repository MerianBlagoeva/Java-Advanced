package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] array = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = array;
        }
        int sumFirstDiagonal = 0;
        int sumSecondDiagonal = 0;

        for (int row = 0; row < n; row++) {
            sumFirstDiagonal += matrix[row][row];
            sumSecondDiagonal += matrix[row][n - 1 - row];
        }
        System.out.println(Math.abs(sumFirstDiagonal - sumSecondDiagonal));
    }
}
