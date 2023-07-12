package Exercises.pizzaCalories;

import java.util.Locale;

public class Topping {

//    private enum Toppings {
//        Meat(1.2),
//        Veggies(0.8),
//        Cheese(1.1),
//        Sauce(0.9);
//
//        private final double modifier;
//
//        Toppings(double modifier) {
//            this.modifier = modifier;
//        }
//    }

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
//        try {
//            this.toppingType = Toppings.valueOf(toppingType).name();
//        } catch (IllegalArgumentException e) {
//            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
//        }

        if (!toppingType.equals("Meat") && !toppingType.equals("Veggies")
            && !toppingType.equals("Cheese") && !toppingType.equals("Sauce")) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }

        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException("Topping type " + this.toppingType + " weight should be in the range [1...50].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
//        return 2 * weight * Toppings.valueOf(toppingType).modifier;

        double modifier = -1;

        switch (toppingType) {
            case "Meat":
                modifier = 1.2;
                break;
            case "Veggies":
                modifier = 0.8;
                break;
            case "Cheese":
                modifier = 1.1;
                break;
            case "Sauce":
                modifier = 0.9;
                break;
        }
        return 2 * weight * modifier;
    }
}
