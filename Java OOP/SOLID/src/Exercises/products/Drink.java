package Exercises.products;

public abstract class Drink implements HasWeight {
    private double milliliters;

    protected Drink (double milliliters) {
        this.milliliters = milliliters;
    }

    public double getVolumeMilliliters() {
        return milliliters;
    }

    @Override
    public double getWeightGrams() {
        return this.getVolumeMilliliters() * getDensity();
    }

    protected abstract double getDensity();

    public double getVolumeLiters() {
        return getVolumeMilliliters() / 1000;
    }

    @Override
    public double getWeightKilograms() {
        return getWeightGrams() / 1000;
    }
}
