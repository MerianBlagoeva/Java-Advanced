import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        try {
            double sqrt = sqrt(input);
            System.out.printf("%.2f%n", sqrt);
        } catch (IllegalArgumentException ignored) {
            System.out.println("Invalid");
        }

        System.out.println("Goodbye");
    }

    private static double sqrt(String input) {

        int number = Integer.parseInt(input);

        if (number < 0) {
            throw new NegativeSQRTInputException("Input " + number + " is negative");
        }

        return Math.sqrt(number);
    }
}
