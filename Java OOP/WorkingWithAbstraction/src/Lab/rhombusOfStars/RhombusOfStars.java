package Lab.rhombusOfStars;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());


        for (int i = 1; i <= n; i++) {
            printRow(i, n - i);
        }
        for (int i = n - 1; i > 0 ; i--) {
            printRow(i, n - i);
        }
    }

    private static void printRow(int stars, int leadingSpaces) {
        for (int i = 0; i < leadingSpaces; i++) {
            System.out.print(" ");
        }

        for (int i = 0; i < stars - 1; i++) {
            System.out.print("* ");
        }
        System.out.println("*");
    }
}
