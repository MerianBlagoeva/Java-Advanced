package MatrixExercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dimensions = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

         String[][] matrix = new String[rows][cols];

        fillMatrix(rows, cols, matrix);
        printMatrix(matrix);
    }

    private static void fillMatrix(int rows, int cols, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                //enter the palindrome
                char outsideLetter = (char) ('a' + row);
                char innerLetter = (char) ('a' + row + col);
                matrix[row][col] = String.valueOf(outsideLetter) + innerLetter + outsideLetter;
            }
        }
    }
    private static void printMatrix(String[][] matrix) {
        for (String[] array : matrix) {
            for (String s : array) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
