package Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int row = 0;
        int col = 0;

        while (row < matrix.length && col < matrix[row].length) {
            System.out.print(matrix[row][col] + " ");
            row++;
            col++;
        }

        System.out.println();

        row = matrix.length - 1;
        col = 0;

        while (row >= 0 && col < matrix[row].length) {
            System.out.print(matrix[row][col] + " ");
            row--;
            col++;
        }
    }
}
