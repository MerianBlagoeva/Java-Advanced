package Exercises.animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String animalType = sc.nextLine();

        while (!animalType.equals("Beast!")) {
            String[] animalParameters = sc.nextLine().split("\\s+");
            String name = animalParameters[0];
            int age = Integer.parseInt(animalParameters[1]);
            String gender = animalParameters[2];

            Animal animal = null;
            try {
                animal = parseAnimal(animalType, name, age, gender);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input!");
            }

            if (animal != null) {
                System.out.println(animal);
            }

            animalType = sc.nextLine();
        }
    }

    private static Animal parseAnimal(String animalType, String name, int age, String gender) {
        switch (animalType) {
            case "Cat":
                return new Cat(name, age, gender);
            case "Dog":
                return new Dog(name, age, gender);
            case "Frog":
                return new Frog(name, age, gender);
            case "Kitten":
                return new Kitten(name, age);
            case "Tomcat":
                return new Tomcat(name, age);
            default:
                throw new IllegalStateException("Unknown animal type: " + animalType);
        }
    }
}
