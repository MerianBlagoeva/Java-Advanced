package Exercises.pizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] pizzaInput = sc.nextLine().split(" ");
        String pizzaName = pizzaInput[1];
        int numberOfToppings = Integer.parseInt(pizzaInput[2]);

        Pizza pizza;
        try {
            pizza = new Pizza(pizzaName, numberOfToppings);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String[] doughInput = sc.nextLine().split(" ");
        String flourType = doughInput[1];
        String bakingTechnique = doughInput[2];
        double weight = Double.parseDouble(doughInput[3]);

        Dough dough;
        try {
            dough = new Dough(flourType, bakingTechnique, weight);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        pizza.setDough(dough);

        String toppingInput = sc.nextLine();

        while (!toppingInput.equals("END")) {

            String[] toppingInfo = toppingInput.split(" ");
            try {
                Topping topping = new Topping(toppingInfo[1], Double.parseDouble(toppingInfo[2]));
                pizza.addTopping(topping);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }

            toppingInput = sc.nextLine();
        }

        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());

    }
}


