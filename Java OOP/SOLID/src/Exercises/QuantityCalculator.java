package Exercises;

import Exercises.products.HasWeight;

public class QuantityCalculator<T extends HasWeight> extends Calculator<T> {

    @Override
    protected double extractValue(T hasWeight) {
        return hasWeight.getWeightKilograms();
    }
}
