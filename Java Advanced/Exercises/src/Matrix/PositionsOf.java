package Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] matrix = readMatrix(sc);
        int n = Integer.parseInt(sc.nextLine());

        List<String> outputLines = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == n) {
                    outputLines.add(row + " " + col);
                }
            }
        }

        System.out.println(formatOutput(outputLines));
    }

    public static String formatOutput(List<String> outputLines) {
        return outputLines.isEmpty() ? "not found" : String.join(System.lineSeparator(), outputLines);
    }

    public static int[][] readMatrix(Scanner sc) {
        String[] dimensions = sc.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
