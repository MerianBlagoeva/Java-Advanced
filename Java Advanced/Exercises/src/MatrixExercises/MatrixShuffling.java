package MatrixExercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dimensions = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        fillMatrix(sc, rows, matrix);

        String command = sc.nextLine();
        while (!command.equals("END")) {
            String[] commandParts = command.split("\\s+");
            if (commandParts[0].equals("swap") && commandParts.length == 5) {
                int row1 = Integer.parseInt(commandParts[1]);
                int col1 = Integer.parseInt(commandParts[2]);
                int row2 = Integer.parseInt(commandParts[3]);
                int col2 = Integer.parseInt(commandParts[4]);

                if (isValid(matrix, row1, col1, row2, col2)) {
                    String oldElement = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = oldElement;
                    printMatrix(matrix);
                } else {
                    System.out.println("Invalid input!");
                }

            } else {
                System.out.println("Invalid input!");
            }
            command = sc.nextLine();
        }
    }

    private static void fillMatrix(Scanner sc, int rows, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = sc.nextLine().split(" ");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] array : matrix) {
            for (String element : array) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValid(String[][] matrix, int row1, int col1, int row2, int col2) {
        return row1 < matrix.length && col1 < matrix[row1].length
               && row2 < matrix.length && col2 < matrix[row2].length;
    }
}
