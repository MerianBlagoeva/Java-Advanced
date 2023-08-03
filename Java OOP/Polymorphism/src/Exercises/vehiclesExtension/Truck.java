package Exercises.vehiclesExtension;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalStateException("Fuel must be a positive number");
        }

        if (this.getTankCapacity() < this.getFuelQuantity() + liters * 0.95) {
            throw new IllegalStateException("Cannot fit fuel in tank");
        }

        this.setFuelQuantity(this.getFuelQuantity() + liters * 0.95);
    }

    @Override
    public double getExtraFuelConsumption() {
        return 1.6;
    }
}
