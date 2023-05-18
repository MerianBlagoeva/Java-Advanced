package Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        Left to right - col++
//        Right to left - col--
//        Up -> row--
//        down - row++

        //TODO: Read input
        String rotation = sc.nextLine();

        String input = sc.nextLine();
        List<String> wordList = new ArrayList<>();
        int maxColumnLength = Integer.MIN_VALUE;

        while (!input.equals("END")) {
            int currentLength = input.length();
            if (currentLength > maxColumnLength) {
                maxColumnLength = currentLength;
            }
            wordList.add(input);

            input = sc.nextLine();
        }
        //Create matrix
        int rows = wordList.size();
        int cols = maxColumnLength;

        char[][] matrix = new char[rows][cols];

        //Fill the matrix
        for (int row = 0; row < rows; row++) {
            String currentWord = wordList.get(row);

            for (int col = 0; col < cols; col++) {
                if (col < currentWord.length()) {
                    char currentChar = currentWord.charAt(col);
                    matrix[row][col] = currentChar;
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
        int angle = Integer.parseInt(rotation.split("[()]")[1]);
        int angleOfRotation = angle % 360;

        printMatrix(rows, cols, matrix, angleOfRotation);

    }

    private static void printMatrix(int rows, int cols, char[][] matrix, int angleOfRotation) {
        switch (angleOfRotation) {
            case 0:
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 90:
                //Rotate to the right
                for (int col = 0; col < cols; col++) {
                    for (int row = rows - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                //Rotate upside down
                for (int row = rows - 1; row >= 0; row--) {
                    for (int col = cols - 1; col >= 0; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                //Rotate to the right
                for (int col = cols - 1; col >= 0; col--) {
                    for (int row = 0; row < rows; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
        }
    }
}
