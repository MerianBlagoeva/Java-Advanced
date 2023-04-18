package Exercises.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] galaxyMatrix = readAndInitializeMatrix(scanner);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {

            int[] jediCoordsArray = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] evilCoords = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            moveEvilAndDestroyStars(galaxyMatrix, new Coords(evilCoords[0], evilCoords[1]));
            sum += moveJediAndCalculateStars(galaxyMatrix, new Coords(jediCoordsArray[0], jediCoordsArray[1]));

            command = scanner.nextLine();
        }

        System.out.println(sum);
    }

    private static long moveJediAndCalculateStars(int[][] galaxyMatrix, Coords jediCoords) {
        long sum = 0;
        while (canJediStillMove(galaxyMatrix, jediCoords)) {

            if (isInMatrix(galaxyMatrix, jediCoords)) {
                sum += galaxyMatrix[jediCoords.row][jediCoords.col];
            }

            jediCoords.row--;
            jediCoords.col++;
        }
        return sum;
    }

    private static boolean isInMatrix(int[][] galaxyMatrix, Coords coords) {
        int galaxyMatrixColumnsLength = galaxyMatrix[0].length;
        return coords.row >= 0 && coords.row < galaxyMatrix.length && coords.col >= 0 && coords.col < galaxyMatrixColumnsLength;
    }

    private static void moveEvilAndDestroyStars(int[][] galaxyMatrix, Coords evilCoords) {
        while (canEvilStillMove(evilCoords)) {

            if (isInMatrix(galaxyMatrix, evilCoords)) {
                galaxyMatrix[evilCoords.row][evilCoords.col] = 0;
            }

            evilCoords.row--;
            evilCoords.col--;
        }
    }

    private static boolean canEvilStillMove(Coords coords) {
        return coords.row >= 0 && coords.col >= 0;
    }

    private static boolean canJediStillMove(int[][] galaxyMatrix, Coords coords) {
        int galaxyMatrixColumnsLength = galaxyMatrix[1].length;
        return coords.row >= 0 && coords.col < galaxyMatrixColumnsLength;
    }

    static int[][] readAndInitializeMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = dimensions[0];
        int y = dimensions[1];

        int[][] matrix = new int[x][y];

        int value = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = value++;
            }
        }
        return matrix;
    }
}
