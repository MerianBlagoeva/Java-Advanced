package Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = sc.nextLine();

        UnaryOperator<List<Integer>> add = numbers -> numbers.stream().map(number -> number + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtract = numbers -> numbers.stream().map(number -> number - 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiply = numbers -> numbers.stream().map(number -> number * 2).collect(Collectors.toList());
        Consumer<List<Integer>> printer = numbers -> numbers.forEach(n -> System.out.print(n + " "));

        while (!command.equals("end")) {
            switch (command) {
                case "add" -> list = add.apply(list);
                case "subtract" -> list = subtract.apply(list);
                case "multiply" -> list = multiply.apply(list);
                case "print" -> {
                    printer.accept(list);
                    System.out.println();
                }
                default -> throw new IllegalArgumentException("Invalid command: " + command);
            }

            command = sc.nextLine();
        }
    }
}
