package Exercises.vehiclesExtension;

public class Bus extends Vehicle {
    boolean nextDriveIsEmpty;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public double getExtraFuelConsumption() {
        if (nextDriveIsEmpty) {
            return 0;
        }
        return 1.4;
    }

    @Override
    public boolean drive(double distance) {
        boolean result = super.drive(distance);
        nextDriveIsEmpty = false;
        return result;
    }

    public void setupEmptyDrive() {
        nextDriveIsEmpty = true;
    }

}
