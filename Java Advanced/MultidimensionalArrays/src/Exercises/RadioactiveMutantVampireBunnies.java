package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies { //преписана (what the hell is this?)
    public static char[][] lair;
    public static int playerRow;
    public static int playerCol;
    public static boolean playerWon;
    public static boolean playerDied;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dimensions = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        lair = new char[dimensions[0]][];
        populateMatrix(sc);

        playerRow = getPlayerRow();
        playerCol = String.valueOf(lair[playerRow]).indexOf("P");

        String input = sc.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char command = input.charAt(i);
            switch (command) {
                case 'U':
                    moveUp();
                    break;
                case 'D':
                    moveDown();
                    break;
                case 'L':
                    moveLeft();
                    break;
                case 'R':
                    moveRight();
                    break;
            }
            spreadBunnies();

            if (playerWon) {
                System.out.println(printWonMessage());
                return;
            }

            if (playerDied || playerCatched()) {
                System.out.println(printDiedMessage());
                return;
            }

        }

    }

    private static boolean playerCatched() {
        boolean isDead = true;
        for (int row = 0; row < lair.length; row++) {
            for (int col = 0; col < lair[row].length; col++) {
                if (lair[row][col] == 'P') {
                    isDead = false;
                }
            }
        }
        return isDead;
    }

    private static void spreadBunnies() {
        for (int row = 0; row < lair.length; row++) {
            for (int col = 0; col < lair[row].length; col++) {
                if (lair[row][col] == 'B') {
                    spread(row, col);
                }
            }
        }
        for (int row = 0; row < lair.length; row++) {
            for (int col = 0; col < lair[row].length; col++) {
                if (lair[row][col] == 'b') {
                    lair[row][col] = 'B';
                }
            }
        }
    }

    private static void spread(int row, int col) {
        if (isInside(row - 1, col) && lair[row - 1][col] != 'B') {
            if (lair[row - 1][col] == 'P') {
                playerDied = true;
            }
            lair[row - 1][col] = 'b';
        }
        if (isInside(row + 1, col) && lair[row + 1][col] != 'B') {
            if (lair[row + 1][col] == 'P') {
                playerDied = true;
            }
            lair[row + 1][col] = 'b';
        }
        if (isInside(row, col - 1) && lair[row][col - 1] != 'B') {
            if (lair[row][col - 1] == 'P') {
                playerDied = true;
            }
            lair[row][col - 1] = 'b';
        }
        if (isInside(row, col + 1) && lair[row][col + 1] != 'B') {
            if (lair[row][col + 1] == 'P') {
                playerDied = true;
            }
            lair[row][col + 1] = 'b';
        }
    }

    private static String printDiedMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append(printLair()).append(System.lineSeparator());
        builder.append(String.format("dead: %d %d%n", playerRow, playerCol));
        return builder.toString();
    }

    private static String printWonMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append(printLair()).append(System.lineSeparator());
        builder.append(String.format("won: %d %d%n", playerRow, playerCol));
        return builder.toString();
    }

    private static void moveRight() {
        lair[playerRow][playerCol] = '.';
        playerCol++;
        if (isInside(playerRow, playerCol)) {
            if (lair[playerRow][playerCol] == 'B') {
                playerDied = true;
            } else {
                lair[playerRow][playerCol] = 'P';
            }
        } else {
            playerWon = true;
            playerCol--;
        }
    }

    private static void moveLeft() {
        lair[playerRow][playerCol] = '.';
        playerCol--;
        if (isInside(playerRow, playerCol)) {
            if (lair[playerRow][playerCol] == 'B') {
                playerDied = true;
            } else {
                lair[playerRow][playerCol] = 'P';
            }
        } else {
            playerWon = true;
            playerCol++;
        }
    }

    private static void moveDown() {
        lair[playerRow][playerCol] = '.';
        playerRow++;
        if (isInside(playerRow, playerCol)) {
            if (lair[playerRow][playerCol] == 'B') {
                playerDied = true;
            } else {
                lair[playerRow][playerCol] = 'P';
            }
        } else {
            playerWon = true;
            playerRow--;
        }
    }

    private static void moveUp() {
        lair[playerRow][playerCol] = '.';
        playerRow--;
        if (isInside(playerRow, playerCol)) {
            if (lair[playerRow][playerCol] == 'B') {
                playerDied = true;
            } else {
                lair[playerRow][playerCol] = 'P';
            }
        } else {
            playerWon = true;
            playerRow++;
        }
    }

    private static int getPlayerRow() {
        int result = -1;
        for (int row = 0; row < lair.length; row++) {
            if (String.valueOf(lair[row]).contains("P")) {
                result = row;
            }
        }
        return result;
    }

    private static void populateMatrix(Scanner sc) {
        for (int row = 0; row < lair.length; row++) {
            lair[row] = sc.nextLine().toCharArray();
        }
    }

    private static boolean isInside(int row, int col) {
        if (row < 0 || row >= lair.length || col < 0 || col >= lair[row].length) {
            return false;
        } else return true;
    }

    private static String printLair() {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < lair.length; row++) {
            builder.append(lair[row]);
            if (row != lair.length - 1) {
                builder.append(System.lineSeparator());
            }
        }
        return builder.toString();
    }
}
 