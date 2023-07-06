package MatrixExamExercises;

import java.util.Scanner;

public class RallyRacing {

    private enum Command {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        END

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String racingNumber = sc.nextLine();

        char[][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {
            matrix[row] = sc.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
        }

        int currentRow = 0;
        int currentCol = 0;

        Command command = Command.valueOf(sc.nextLine().toUpperCase());

        int distanceCovered = 0;

        while (!command.equals(Command.END)) {
            switch (command) {
                case UP:
                    if (currentRow - 1 >= 0) {
                        currentRow--;
                    }
                    break;
                case DOWN:
                    if (currentRow + 1 < n) {
                        currentRow++;
                    }
                    break;
                case RIGHT:
                    if (currentCol + 1 < n) {
                        currentCol++;
                    }
                    break;
                case LEFT:
                    if (currentCol - 1 >= 0) {
                        currentCol--;
                    }
                    break;

            }
            if (isEmptySpace(matrix, currentRow, currentCol)) {
                distanceCovered += 10;
            } else if (isTunnel(matrix, currentRow, currentCol)) {
                int[] newCoords = passTroughTunnel(matrix, currentRow, currentCol);
                currentRow = newCoords[0];
                currentCol = newCoords[1];
                distanceCovered += 30;
            }

            if (isFinish(matrix, currentRow, currentCol)) {
                distanceCovered += 10;
                System.out.printf("Racing car %s finished the stage!%n", racingNumber);
                printInfo(matrix, currentRow, currentCol, distanceCovered);
                return;
            }

            command = Command.valueOf(sc.nextLine().toUpperCase());
        }
        if (!isFinish(matrix, currentRow, currentCol)) {
            System.out.printf("Racing car %s DNF.%n", racingNumber);
            printInfo(matrix, currentRow, currentCol, distanceCovered);
        }
    }

    private static void printInfo(char[][] matrix, int currentRow, int currentCol, int distanceCovered) {
        matrix[currentRow][currentCol] = 'C';
        System.out.printf("Distance covered %s km.%n", distanceCovered);
        printMatrix(matrix);
    }

    private static boolean isTunnel(char[][] matrix, int currentRow, int currentCol) {
        return matrix[currentRow][currentCol] == 'T';
    }

    private static int[] passTroughTunnel(char[][] matrix, int currentRow, int currentCol) {
        matrix[currentRow][currentCol] = '.';
        int[] newCoords = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'T') {
                    currentRow = row;
                    currentCol = col;
                    matrix[currentRow][currentCol] = '.';
                    newCoords[0] = currentRow;
                    newCoords[1] = currentCol;
                }
            }
        }
        return newCoords;
    }

    private static boolean isFinish(char[][] matrix, int currentRow, int currentCol) {
        return matrix[currentRow][currentCol] == 'F';
    }

    private static boolean isEmptySpace(char[][] matrix, int currentRow, int currentCol) {
        return matrix[currentRow][currentCol] == '.';
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
