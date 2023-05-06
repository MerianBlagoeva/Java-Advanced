package Lab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());

        char[][] first = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            first[row] = sc.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
        }
        char[][] second = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            second[row] = sc.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char firstElement = first[row][col];
                char secondElement = second[row][col];
                char fillChar = firstElement == secondElement ? firstElement : '*';
                System.out.print(fillChar + " ");
            }
            System.out.println();
        }
    }
}