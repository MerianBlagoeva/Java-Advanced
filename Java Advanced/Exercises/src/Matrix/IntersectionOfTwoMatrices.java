package Matrix;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());

        char[][] first = readMatrix(sc, rows, cols);
        char[][] second = readMatrix(sc, rows, cols);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char firstChar = first[row][col];
                char secondChar = second[row][col];
                char fillChar = firstChar == secondChar ? firstChar : '*';
                System.out.print(fillChar + " ");
            }
            System.out.println();
        }
    }

    public static char[][] readMatrix(Scanner sc, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = sc.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
        }
        return matrix;
    }
}
