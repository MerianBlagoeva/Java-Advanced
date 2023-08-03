package Exercises.products;

public class Chips extends Food implements Product {
    private double weightGrams;

    public Chips(double weightGrams) {
        super(weightGrams);
    }

    @Override
    public double getCaloriesPer100Grams() {
        return 529;
    }
}
