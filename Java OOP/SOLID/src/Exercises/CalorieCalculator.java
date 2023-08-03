package Exercises;


import Exercises.products.Product;

public class CalorieCalculator extends Calculator<Product> {
    public CalorieCalculator() {
    }

    private static double calculateCalories(double grams, double caloriesPer100Grams) {
        return (caloriesPer100Grams / 100) * grams;
    }

    @Override
    protected double extractValue(Product product) {
        return calculateCalories(product.getWeightGrams(), product.getCaloriesPer100Grams());
    }
}
