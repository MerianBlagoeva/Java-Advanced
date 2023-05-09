package Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());

        int[][] matrix = new int[size][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = readArray(sc);
        }

        int[] indices = readArray(sc);

        int valueToReplace = matrix[indices[0]][indices[1]];

        List<int[]> correctValues = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == valueToReplace) {
                    int correctValue = getNearbySum(matrix, row, col, valueToReplace);
                    correctValues.add(new int[]{row, col, correctValue});
                }
            }
        }

        for (int[] correctValue : correctValues) {
            int row = correctValue[0];
            int col = correctValue[1];
            matrix[row][col] = correctValue[2];
        }

        for (int[] arr : matrix) {
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    private static int getNearbySum(int[][] matrix, int r, int c, int valueToReplace) {
        int sum = 0;

        if (isInBounds(matrix, r + 1, c) && matrix[r + 1][c] != valueToReplace) {
            sum += matrix[r + 1][c];
        }
        if (isInBounds(matrix, r - 1, c) && matrix[r - 1][c] != valueToReplace) {
            sum += matrix[r - 1][c];
        }
        if (isInBounds(matrix, r, c - 1)  && matrix[r][c - 1] != valueToReplace) {
            sum += matrix[r][c - 1];
        }
        if (isInBounds(matrix, r, c + 1)  && matrix[r][c + 1] != valueToReplace) {
            sum += matrix[r][c + 1];
        }

        return sum;
    }

    private static boolean isInBounds(int[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    private static boolean isOutOfBounds(int[][] matrix, int r, int c) {
        return !isInBounds(matrix, r, c);
    }


    private static int[] readArray(Scanner sc) {
        return Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
