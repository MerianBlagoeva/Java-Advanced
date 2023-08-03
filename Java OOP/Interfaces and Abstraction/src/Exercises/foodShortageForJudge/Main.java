package Exercises.foodShortageForJudge;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Buyer> buyersByName = new HashMap<>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String paramsString = sc.nextLine();
            String[] parameters = paramsString.split("\\s+");

            switch (parameters.length) {
                case 3:
                    Rebel rebel = new Rebel(parameters[0], Integer.parseInt(parameters[1]), parameters[2]);
                    buyersByName.put(parameters[0], rebel);
                    break;
                case 4:
                    Citizen citizen = new Citizen(parameters[0], Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
                    buyersByName.put(parameters[0], citizen);
                    break;
                default:
                    throw new IllegalStateException("Unknown input: " + paramsString);
            }
        }

        FoodShortageHandler handler = new FoodShortageHandler(buyersByName, "End", "\\s+");

        handler.readAndHandleCommandsToEnd(sc);

        System.out.println(buyersByName.values().stream().mapToInt(Buyer::getFood).sum());
    }
}
