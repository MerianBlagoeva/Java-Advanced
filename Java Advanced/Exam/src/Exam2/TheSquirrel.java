package Exam2;

import java.util.Scanner;

public class TheSquirrel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] directions = sc.nextLine().split(", ");

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
                if (matrix[row][col] == 's') {
                    currentRow = row;
                    currentCol = col;
                }
            }
        }

        int hazelnutsCollected = 0;

        for (String currentDirection : directions) {
            switch (currentDirection) {
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
                case "right":
                    currentCol++;
                    break;
                case "left":
                    currentCol--;
                    break;
            }

            if (currentRow < 0 || currentRow >= n || currentCol < 0 || currentCol >= n) {
                System.out.println("The squirrel is out of the field.");
                printHazelnutsCount(hazelnutsCollected);
                return;
            }

            if (matrix[currentRow][currentCol] == 'h') {
                hazelnutsCollected++;
                matrix[currentRow][currentCol] = '*';
                if (hazelnutsCollected == 3) {
                    System.out.println("Good job! You have collected all hazelnuts!");
                    printHazelnutsCount(hazelnutsCollected);
                    return;
                }
            } else if (matrix[currentRow][currentCol] == 't') {
                System.out.println("Unfortunately, the squirrel stepped on a trap...");
                printHazelnutsCount(hazelnutsCollected);
                return;
            }
        }

        String output = hazelnutsCollected >= 3 ?
                "Good job! You have collected all hazelnuts!" :
                "There are more hazelnuts to collect.";

        System.out.println(output);
        printHazelnutsCount(hazelnutsCollected);
    }

    private static void printHazelnutsCount(int hazelnutsCollected) {
        System.out.println("Hazelnuts collected: " + hazelnutsCollected);
    }
}
