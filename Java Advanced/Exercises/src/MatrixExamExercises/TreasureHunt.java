package MatrixExamExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {

    private enum Command {
        UP,
        DOWN,
        RIGHT,
        LEFT,
        FINISH
    }

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
                if (matrix[row][col] == 'Y') {
                    currentRow = row;
                    currentCol = col;
                }
            }
        }

        Command command = Command.valueOf(sc.nextLine().toUpperCase());

        List<String> moves = new ArrayList<>();

        while (!command.equals(Command.FINISH)) {
            switch (command) {
                case UP:
                    if (currentRow - 1 >= 0 && matrix[currentRow - 1][currentCol] != 'T') {
                        currentRow--;
                        moves.add(String.valueOf(command).toLowerCase());
                    }
                    break;
                case DOWN:
                    if (currentRow + 1 < rows && matrix[currentRow + 1][currentCol] != 'T') {
                        currentRow++;
                        moves.add(String.valueOf(command).toLowerCase());
                    }
                    break;
                case LEFT:
                    if (currentCol - 1 >= 0 && matrix[currentRow][currentCol - 1] != 'T') {
                        currentCol--;
                        moves.add(String.valueOf(command).toLowerCase());
                    }
                    break;
                case RIGHT:
                    if (currentCol + 1 < cols && matrix[currentRow][currentCol + 1] != 'T') {
                        currentCol++;
                        moves.add(String.valueOf(command).toLowerCase());
                    }
                    break;
            }
            command = Command.valueOf(sc.nextLine().toUpperCase());
        }
        if (matrix[currentRow][currentCol] == 'X') {
            System.out.println("I've found the treasure!");
            System.out.println("The right path is " + String.join(", ", moves));
        } else {
            System.out.println("The map is fake!");
        }
    }
}
