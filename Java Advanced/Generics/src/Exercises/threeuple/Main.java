package Exercises.threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");
        String name = input[0] + " " + input[1];
        String address = input[2];
        String city = input[3];

        Threeuple<String, String, String> firstThreeuple = new Threeuple<>(name, address, city);

        input = sc.nextLine().split("\\s+");

        String firstName = input[0];
        Integer beerLiters = Integer.parseInt(input[1]);
        boolean isDrunk = input[2].equals("drunk");

        Threeuple<String, Integer, Boolean> secondThreeuple = new Threeuple<>(firstName, beerLiters, isDrunk);

        input = sc.nextLine().split("\\s+");

        String fName = input[0];
        Double accountBalance = Double.parseDouble(input[1]);
        String bankName = input[2];

        Threeuple<String, Double, String> thirdThreeuple = new Threeuple<>(fName, accountBalance, bankName);

        System.out.println(firstThreeuple);
        System.out.println(secondThreeuple);
        System.out.println(thirdThreeuple);
    }
}
