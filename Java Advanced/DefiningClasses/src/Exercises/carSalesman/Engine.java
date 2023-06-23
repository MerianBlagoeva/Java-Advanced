package Exercises.carSalesman;

public class Engine {
    private String model;
    private String power;
    private String displacement = "n/a";
    private String efficiency = "n/a";

    public Engine(String model, String power, String displacement, String efficiency) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;

    }

    public Engine(String model, String power, String displacement) {
        this(model, power);
        if (Character.isDigit(displacement.charAt(0))) {
            this.displacement = displacement;
        } else {
            this.efficiency = displacement;
        }
    }

    public Engine(String model, String power) {
        this.model = model;
        this.power = power;
    }


    public String getModel() {
        return model;
    }

    public String getPower() {
        return power;
    }

    public String getDisplacement() {
        return displacement;
    }


    public String getEfficiency() {
        return efficiency;
    }

}
