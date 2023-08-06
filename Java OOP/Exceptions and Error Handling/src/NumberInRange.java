import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] range = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        System.out.printf("Range: [%d...%d]%n", range[0], range[1]);
        boolean isValidInput = false;

        while (!isValidInput) {
            String nextInput = sc.nextLine();

            Optional<Integer> number = Optional.empty();

            try {
                number = Optional.of(Integer.parseInt(nextInput));
            } catch (NumberFormatException ignored) {
            }

            String output = "Invalid number: " + nextInput;

            if (number.isPresent() && isInRange(range, number.get())) {
                output = "Valid number: " + number.get();
                isValidInput = true;
            }

            System.out.println(output);
        }
    }

    private static boolean isInRange(int[] range, int number) {
        return number >= range[0] && number <= range[1];
    }
}
