import java.util.Scanner;

public class PrintStringByWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String[] tokens = input.toUpperCase().split("[\\W]+");

        System.out.println(String.join(", ", tokens));
    }
}
