package Exercises.shoppingSpree;

public class Validations {
    public static void validateName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    public static void validateMoney(Double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }
}
