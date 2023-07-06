package Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] dimensions = sc.nextLine().split(", ");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        readMatrix(sc, rows, matrix);

        int sum = getSum(rows, cols, matrix);
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }

    private static void readMatrix(Scanner sc, int rows, int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            int[] column = Arrays.stream(sc.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = column;
        }
    }

    private static int getSum(int rows, int cols, int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }
}
