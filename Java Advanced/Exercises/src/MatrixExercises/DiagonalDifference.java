package MatrixExercises;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int[][] matrix = new int[n][n];


        fillMatrix(sc, n, matrix);

        int sumFirstDiagonal = 0;
        int sumSecondDiagonal = 0;

        for (int row = 0; row < n; row++) {
            sumFirstDiagonal += matrix[row][row];
            sumSecondDiagonal += matrix[row][n - row - 1];
        }

        System.out.println(Math.abs(sumFirstDiagonal - sumSecondDiagonal));
    }

    private static void fillMatrix(Scanner sc, int n, int[][] matrix) {
        for (int row = 0; row < n; row++) {
            int[] array = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = array;
        }
    }
}
