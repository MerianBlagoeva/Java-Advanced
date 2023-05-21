package ExamExercises;

import java.util.Scanner;

public class RallyRacing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String racingNumber = sc.nextLine();

        String[][] matrix = new String[n][n];

        for (int i = 0; i < n; i++) {
            String[] array = sc.nextLine().split(" ");
            matrix[i] = array;
        }

        int currentRow = 0;
        int currentCol = 0;

        int distance = 0;

        String command = sc.nextLine();
        while (!command.equals("End")) {


            switch (command) {
                case "down":
                    currentRow++;

                    if (!matrix[currentRow][currentCol].equals("T")) {
                        distance += 10;
                    }
                    break;
                case "right":
                    currentCol++;

                    if (!matrix[currentRow][currentCol].equals("T")) {
                        distance += 10;
                    }
                    break;
                case "up":
                    currentRow--;

                    if (!matrix[currentRow][currentCol].equals("T")) {
                        distance += 10;
                    }
                    break;
                case "left":
                    currentCol--;
                    if (!matrix[currentRow][currentCol].equals("T")) {
                        distance += 10;
                    }
                    break;
            }
            if (matrix[currentRow][currentCol].equals("T")) {
                matrix[currentRow][currentCol] = ".";
                distance += 30;

                for (int row = 0; row < n; row++) {
                    for (int col = 0; col < n; col++) {

                        if (matrix[row][col].equals("T")) {
                            currentRow = row;
                            currentCol = col;
                            matrix[row][col] = ".";

                        }
                    }
                }
            }

            if (matrix[currentRow][currentCol].equals("F")) {
                System.out.printf("Racing car %s finished the stage!%n", racingNumber);
                break;
            }
            command = sc.nextLine();
        }
        if (command.equals("End")) {
            System.out.printf("Racing car %s DNF.%n", racingNumber);
        }
        System.out.printf("Distance covered %d km.%n", distance);
        matrix[currentRow][currentCol] = "C";
        printMatrix(matrix);
    }
    public static void printMatrix(String[][] matrix) {
        for (String[] array : matrix) {
            for (String s : array) {
                System.out.print(s);
            }
            System.out.println();
        }
    }
}
