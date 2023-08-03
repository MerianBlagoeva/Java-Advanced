package Exercises.foodShortageAbstractClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<BuyingPerson> buyers = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String paramsString = sc.nextLine();
            String[] parameters = paramsString.split("\\s+");

            switch (parameters.length) {
                case 3:
                    Rebel rebel = new Rebel(parameters[0], Integer.parseInt(parameters[1]), parameters[2]);
                    buyers.add(rebel);
                    break;
                case 4:
                    Citizen citizen = new Citizen(parameters[0], Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
                    buyers.add(citizen);
                    break;
                default:
                    throw new IllegalStateException("Unknown input: " + paramsString);
            }
        }

        FoodShortageHandler handler = new FoodShortageHandler(buyers, "End", "\\s+");

        handler.readAndHandleCommandsToEnd(sc);

        System.out.println(buyers.stream()
                .mapToInt(BuyingPerson::getFood)
                .sum());
    }
}
