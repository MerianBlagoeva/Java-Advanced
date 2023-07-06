package MatrixExercises;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[size][size];
        int counter = 1;

        matrix = pattern.equals("A") ? fillMatrixPatternA(matrix, counter) : fillMatrixPatternB(matrix, counter);

        printMatrix(matrix);


    }
    private static int[][] fillMatrixPatternA(int[][] matrix, int counter) {
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = counter;
                counter++;
            }
        }
        return matrix;
    }
    private static int[][] fillMatrixPatternB(int[][] matrix, int counter) {

        for (int col = 0; col < matrix.length; col++) {
            //even
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            } else {
                //odd
                for (int row = matrix.length - 1; row >= 0 ; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
        }
        return matrix;
    }
    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(ints[col] + " ");
            }
            System.out.println();
        }
    }
}
