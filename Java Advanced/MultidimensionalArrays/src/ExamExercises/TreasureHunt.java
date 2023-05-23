package ExamExercises;

import java.util.*;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dimensions = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        List<String> moves = new ArrayList<>();


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
        String command = sc.nextLine();
        while (!command.equals("Finish")) {
            switch (command) {
                case "up":
                    if (currentRow - 1 >= 0 && matrix[currentRow - 1][currentCol] != 'T') {
                        currentRow--;
                        moves.add(command);
                    }

                    break;
                case "down":
                    if (currentRow + 1 < rows && matrix[currentRow + 1][currentCol] != 'T') {
                        currentRow++;
                        moves.add(command);
                    }

                    break;
                case "right":
                    if (currentCol + 1 < cols && matrix[currentRow][currentCol + 1] != 'T') {
                        currentCol++;
                        moves.add(command);
                    }

                    break;
                case "left":
                    if (currentCol - 1 >= 0 && matrix[currentRow][currentCol - 1] != 'T') {
                        currentCol--;
                        moves.add(command);

                    }
                    break;
            }

            command = sc.nextLine();
        }

        if (matrix[currentRow][currentCol] == 'X') {
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");
            System.out.println(moves.toString().replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("The map is fake!");
        }
    }

}
