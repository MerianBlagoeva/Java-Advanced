package Exercises.vehicles;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public boolean drive(double distance) {
        double fuelQuantityNeeded = fuelConsumption * distance;
        if (fuelQuantityNeeded <= fuelQuantity) {
            this.fuelQuantity -= fuelQuantityNeeded;
            return true;
        }
        return false;
    }

    public abstract void refuel(double liters);
}
