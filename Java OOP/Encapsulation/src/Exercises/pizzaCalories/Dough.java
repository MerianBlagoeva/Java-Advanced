package Exercises.pizzaCalories;

public class Dough {
//    private enum FlourType {
//        White(1.5),
//        Wholegrain(1.0);
//
//        private final double modifier;
//
//        FlourType(double modifier) {
//            this.modifier = modifier;
//        }
//    }
//
//    private enum BakingTechnique {
//        Crispy(0.9),
//        Chewy(1.1),
//        Homemade(1.0);
//
//        private final double modifier;
//
//        BakingTechnique(double modifier) {
//            this.modifier = modifier;
//        }
//    }

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1...200].");
        }

        this.weight = weight;
    }

    private void setFlourType(String flourType) {
//        try {
//            this.flourType = FlourType.valueOf(flourType).name();
//        } catch (IllegalArgumentException e) {
//            throw new IllegalArgumentException("Invalid type of dough.");
//        }

        if (!flourType.equals("White") && !flourType.equals("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
//        try {
//            this.bakingTechnique = BakingTechnique.valueOf(bakingTechnique).name();
//        } catch (IllegalArgumentException e) {
//            throw new IllegalArgumentException("Invalid type of dough.");
//        }

        if (!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy") && !bakingTechnique.equals("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

        this.bakingTechnique = bakingTechnique;
    }

    public double calculateCalories() {
//        return 2 * weight * FlourType.valueOf(flourType).modifier
//               * BakingTechnique.valueOf(bakingTechnique).modifier;

        double flourTypeModifier = -1;

        switch (flourType) {
            case "White":
                flourTypeModifier = 1.5;
                break;
            case "Wholegrain":
                flourTypeModifier = 1.0;
                break;
        }

        double bakingModifier = -1;
        switch (bakingTechnique) {
            case "Crispy":
                bakingModifier = 0.9;
                break;
            case "Chewy":
                bakingModifier = 1.1;
                break;
            case "Homemade":
                bakingModifier = 1.0;
        }

        return 2 * weight * flourTypeModifier * bakingModifier;
    }
}
