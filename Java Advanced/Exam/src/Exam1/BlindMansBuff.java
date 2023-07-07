package Exam1;

import java.util.Arrays;
import java.util.Scanner;

public class BlindMansBuff {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] dimensions = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = sc.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
        }

        int currentRow = -1;
        int currentCol = -1;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 'B') {
                    currentRow = row;
                    currentCol = col;
                }
            }
        }

        String command = sc.nextLine();

        int opponentsTouched = 0;
        int movesMade = 0;

        while (!command.equals("Finish")) {

            switch (command) {
                case "up":
                    if (currentRow - 1 >= 0 && matrix[currentRow - 1][currentCol] != 'O') {
                        currentRow--;
                        movesMade++;
                    }
                    break;
                case "down":
                    if (currentRow + 1 < rows && matrix[currentRow + 1][currentCol] != 'O') {
                        currentRow++;
                        movesMade++;
                    }
                    break;
                case "right":
                    if (currentCol + 1 < cols && matrix[currentRow][currentCol + 1] != 'O') {
                        currentCol++;
                        movesMade++;
                    }
                    break;
                case "left":
                    if (currentCol - 1 >= 0 && matrix[currentRow][currentCol - 1] != 'O') {
                        currentCol--;
                        movesMade++;
                    }
                    break;
            }

            if (matrix[currentRow][currentCol] == 'P') {
                opponentsTouched++;
                matrix[currentRow][currentCol] = '-';
            }
            if (noMoreOpponentsLeft(matrix)) {
                printInfo(opponentsTouched, movesMade);
                return;
            }
            command = sc.nextLine();
        }
        printInfo(opponentsTouched, movesMade);
    }


    private static void printInfo(int opponentsTouched, int movesMade) {
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d%n", opponentsTouched, movesMade);
    }

    private static boolean noMoreOpponentsLeft(char[][] matrix) {
        for (char[] chars : matrix) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (chars[col] == 'P') {
                    return false;
                }
            }
        }
        return true;
    }

}
