package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            int[] array = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = array;
        }
        int[] wrongValueIndexes = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int wrongValue = matrix[wrongValueIndexes[0]][wrongValueIndexes[1]];

        int[][] fixedMatrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            fixedMatrix[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }


        for (int i = 0; i < rows; i++) {
            int[] array = matrix[i];
            for (int j = 0; j < array.length; j++) {
                if (matrix[i][j] == wrongValue) {
                    int sum = 0;

                    if (j > 0 && matrix[i][j-1] != wrongValue) {
                        sum += matrix[i][j-1];
                    }

                    // Check the element to the right (if it exists)
                    if (j < matrix[i].length - 1 && matrix[i][j+1] != wrongValue) {
                        sum += matrix[i][j+1];
                    }

                    // Check the element above (if it exists)
                    if (i > 0 && matrix[i-1][j] != wrongValue) {
                        sum += matrix[i-1][j];
                    }

                    // Check the element below (if it exists)
                    if (i < rows - 1 && matrix[i+1][j] != wrongValue) {
                        sum += matrix[i+1][j];
                    }

                    // Replace the wrong value with the sum
                    fixedMatrix[i][j] = sum;
                }
            }
        }

        printMatrix(fixedMatrix);
    }
    public static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
