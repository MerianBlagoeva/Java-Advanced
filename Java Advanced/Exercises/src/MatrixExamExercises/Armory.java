package MatrixExamExercises;

import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        char[][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {
            matrix[row] = sc.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
        }
        int currentRow = -1;
        int currentCol = -1;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 'A') {
                    currentRow = row;
                    currentCol = col;
                }
            }
        }

        int goldCoins = 0;

        while (true) {
            String command = sc.nextLine();
            matrix[currentRow][currentCol] = '-';
            switch (command) {
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;
            }

            if (!(currentRow >= 0 && currentRow < n && currentCol >= 0 && currentCol < n)) {
                System.out.println("I do not need more swords!");
                System.out.printf("The king paid %d gold coins.%n", goldCoins);
                printMatrix(matrix);
                return;
            }
            if (Character.isDigit(matrix[currentRow][currentCol])) {
                goldCoins += Integer.parseInt(String.valueOf(matrix[currentRow][currentCol]));
                matrix[currentRow][currentCol] = '-';
            } else if (matrix[currentRow][currentCol] == 'M') {
                matrix[currentRow][currentCol] = '-';
                for (int row = 0; row < n; row++) {
                    for (int col = 0; col < n; col++) {
                        if (matrix[row][col] == 'M') {
                            currentRow = row;
                            currentCol = col;
                            matrix[row][col] = '-';
                        }
                    }
                }
            }
            if (goldCoins >= 65) {
                matrix[currentRow][currentCol] = 'A';
                System.out.println("Very nice swords, I will come back for more!");
                System.out.printf("The king paid %d gold coins.%n", goldCoins);
                printMatrix(matrix);
               return;
            }
        }
    }
    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }
}
