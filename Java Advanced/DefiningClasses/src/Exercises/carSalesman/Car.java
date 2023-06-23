package Exercises.carSalesman;

public class Car {
    private String model;
    private Engine engine;
    private String weight = "n/a";
    private String color = "n/a";

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car(String model, Engine engine, String weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, String weight) {
        this(model, engine);
        if (Character.isDigit(weight.charAt(0))) {
            this.weight = weight;
        } else {
            this.color = weight;
        }
    }


    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return String.format("%s:%n" +
                             "  %s:%n" +
                             "    Power: %s%n" +
                             "    Displacement: %s%n" +
                             "    Efficiency: %s%n" +
                             "  Weight: %s%n" +
                             "  Color: %s", model, getEngine().getModel(),
                getEngine().getPower(),
                getEngine().getDisplacement(),
                getEngine().getEfficiency(),
                weight,
                color);
    }
}
