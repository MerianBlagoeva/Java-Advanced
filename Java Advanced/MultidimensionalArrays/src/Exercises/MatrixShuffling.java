package Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = input[0];
        int cols = input[1];
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] array = sc.nextLine().split(" ");
            matrix[row] = array;
        }

        String regex = "^swap\\s\\d+\\s\\d+\\s\\d+\\s\\d+$";
        Pattern pattern = Pattern.compile(regex);

        String command = sc.nextLine();
        while (!command.equals("END")) {
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                String[] commandParts = command.split(" ");
                int row1 = Integer.parseInt(commandParts[1]);
                int col1 = Integer.parseInt(commandParts[2]);
                int row2 = Integer.parseInt(commandParts[3]);
                int col2 = Integer.parseInt(commandParts[4]);

                if (row1 >= 0 && row1 < matrix.length &&
                    row2 >= 0 && row2 < matrix.length &&
                    col1 >= 0 && col1 < matrix[row1].length &&
                    col2 >= 0 && col2 < matrix[row2].length) {
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

    private static void printMatrix(String[][] matrix) {
        for (String[] array : matrix) {
            for (String element : array) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
