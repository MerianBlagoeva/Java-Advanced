package MatrixExamExercises;

import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] directions = sc.nextLine().split(",");

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
                if (matrix[row][col] == 'D') {
                    currentRow = row;
                    currentCol = col;
                }
            }
        }

        int totalRobbed = 0;


        for (String direction : directions) {
            switch (direction) {
                case "up":
                    if (currentRow - 1 >= 0) {
                        matrix[currentRow][currentCol] = '+';
                        currentRow--;
                    } else {
                        printWarning();
                    }
                    break;
                case "down":
                    if (currentRow + 1 < n) {
                        matrix[currentRow][currentCol] = '+';
                        currentRow++;
                    } else {
                        printWarning();
                    }
                    break;
                case "left":
                    if (currentCol - 1 >= 0) {
                        matrix[currentRow][currentCol] = '+';
                        currentCol--;
                    } else {
                        printWarning();
                    }
                    break;
                case "right":
                    if (currentCol + 1 < n) {
                        matrix[currentRow][currentCol] = '+';
                        currentCol++;
                    } else {
                        printWarning();
                    }
                    break;
            }
            if (matrix[currentRow][currentCol] == '$') {
                matrix[currentRow][currentCol] = '+';
                int currentRobberyAmount = currentRow * currentCol;
                totalRobbed += currentRobberyAmount;
                System.out.printf("You successfully stole %d$.%n", currentRobberyAmount);
            } else if (matrix[currentRow][currentCol] == 'P') {
                System.out.printf("You got caught with %d$, and you are going to jail.%n", totalRobbed);
                matrix[currentRow][currentCol] = '#';
                printMatrix(matrix);
                return;
            }
        }

        matrix[currentRow][currentCol] = 'D';

        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalRobbed);
        printMatrix(matrix);

    }

    private static void printWarning() {
        System.out.println("You cannot leave the town, there is police outside!");
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
