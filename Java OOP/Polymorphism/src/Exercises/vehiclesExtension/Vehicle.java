package Exercises.vehiclesExtension;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;
    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumption(fuelConsumption);
        setTankCapacity(tankCapacity);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalStateException("Fuel must be a positive number");
        }

        this.fuelQuantity = fuelQuantity;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public boolean drive(double distance) {
        double fuelQuantityNeeded = distance * (fuelConsumption + getExtraFuelConsumption());

        if (fuelQuantity > fuelQuantityNeeded) {
            this.fuelQuantity -= fuelQuantityNeeded;
            return true;
        }
        return false;
    }

    public void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalStateException("Fuel must be a positive number");
        }

        if (this.getTankCapacity() < this.getFuelQuantity() + liters) {
            throw new IllegalStateException("Cannot fit fuel in tank");
        }

        this.setFuelQuantity(this.getFuelQuantity() + liters);
    }

    protected abstract double getExtraFuelConsumption();
}
