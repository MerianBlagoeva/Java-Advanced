package Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dimensions = Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[0];

        int[][] matrix = new int[rows][cols];

        //Read the matrix
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(sc.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] maxSumMatrix = new int[2][2];

        int maxSum = Integer.MIN_VALUE;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {

                //Everytime get the sum of the current matrix elements
                int sum = matrix[row][col] + matrix[row][col + 1]
                          + matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (sum > maxSum) {
                    maxSum = sum;

                    //When we find the maxSum it means that the current matrix indices
                    //form the matrix with the largest sum from its elements:
                    maxSumMatrix[0][0] = matrix[row][col];
                    maxSumMatrix[0][1] = matrix[row][col + 1];
                    maxSumMatrix[1][0] = matrix[row + 1][col];
                    maxSumMatrix[1][1] = matrix[row + 1][col + 1];
                }
            }
        }

        //Print the matrix
        for (int[] array : maxSumMatrix) {
            for (int n : array) {
                System.out.print(n + " ");
            }
            System.out.println();
        }

        System.out.println(maxSum);
    }
}
