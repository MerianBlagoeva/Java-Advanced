package Exercises.vehiclesExtension;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public double getExtraFuelConsumption() {
        return 0.9;
    }
}
