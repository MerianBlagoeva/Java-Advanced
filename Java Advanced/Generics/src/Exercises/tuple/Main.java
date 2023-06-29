package Exercises.tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");
        String name = input[0] + " " + input[1];
        String city = input[2];

        Tuple<String, String> firstTuple = new Tuple<>(name, city);

        input = sc.nextLine().split("\\s+");

        String firstName = input[0];
        Integer beerLiters = Integer.parseInt(input[1]);

        Tuple<String, Integer> secondTuple = new Tuple<>(firstName, beerLiters);

        input = sc.nextLine().split("\\s+");

        Integer number = Integer.parseInt(input[0]);
        Double decimal = Double.parseDouble(input[1]);

        Tuple<Integer, Double> thirdTuple = new Tuple<>(number, decimal);

        System.out.println(firstTuple);
        System.out.println(secondTuple);
        System.out.println(thirdTuple);

    }
}
