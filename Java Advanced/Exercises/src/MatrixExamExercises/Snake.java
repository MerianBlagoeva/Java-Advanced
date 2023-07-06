package MatrixExamExercises;

import java.util.Scanner;

public class Snake {
    private enum Direction {
        up,
        down,
        left,
        right
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            matrix[i] = sc.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
        }

        int currentRow = -1;
        int currentCol = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'S') {
                    currentRow = i;
                    currentCol = j;
                    matrix[currentRow][currentCol] = '.';
                }
            }
        }

        int foodEaten = 0;

        while (true) {
            Direction direction = Direction.valueOf(sc.nextLine());
            switch (direction) {
                case up:
                    currentRow--;
                    break;
                case down:
                    currentRow++;
                    break;
                case left:
                    currentCol--;
                    break;
                case right:
                    currentCol++;
                    break;
            }

            if (!(currentRow >= 0 && currentRow < n && currentCol >= 0 && currentCol < n)) {
                break;
            }

            if (matrix[currentRow][currentCol] == 'B') {
                matrix[currentRow][currentCol] = '.';
                for (int row = 0; row < n; row++) {
                    for (int col = 0; col < n; col++) {
                        if (matrix[row][col] == 'B') {
                            currentRow = row;
                            currentCol = col;
                        }
                    }
                }
            } else if (matrix[currentRow][currentCol] == '*') {
                foodEaten++;
                matrix[currentRow][currentCol] = 'S';
            }

            if (isFed(matrix, foodEaten)) {
                return;
            }

            matrix[currentRow][currentCol] = '.';
        }

        System.out.println("Game over!");
        System.out.println("Food eaten: " + foodEaten);
        printMatrix(matrix);
    }

    private static boolean isFed(char[][] matrix, int foodEaten) {
        if (foodEaten >= 10) {
            System.out.println("You won! You fed the snake.");
            System.out.println("Food eaten: " + foodEaten);
            printMatrix(matrix);
            return true;
        }
        return false;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] array : matrix) {
            for (char c : array) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
