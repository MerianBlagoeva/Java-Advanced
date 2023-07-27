package Lab.wildFarmDoesntWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        int counter = 0;

        Food food = null;
        Animal animal = null;

        List<Animal> animals = new ArrayList<>();

        while (!input.equals("End")) {

            if (counter % 2 == 0) {
                String[] animalInfo = input.split("\\s+");

                String animalType = animalInfo[0];
                String animalName = animalInfo[1];
                Double animalWeight = Double.parseDouble(animalInfo[2]);
                String animalLivingRegion = animalInfo[3];
                String catBreed = null;

                if (animalType.equals("Cat")) {
                    catBreed = animalInfo[4];
                }


                switch (animalType) {
                    case "Cat":
                        animal = new Cat(animalName, animalWeight, animalLivingRegion, catBreed);
                        break;
                    case "Tiger":
                        animal = new Tiger(animalName, animalWeight, animalLivingRegion);
                        break;
                    case "Mouse":
                        animal = new Mouse(animalName, animalWeight, animalLivingRegion);
                        break;
                    case "Zebra":
                        animal = new Zebra(animalName, animalWeight, animalLivingRegion);
                        break;
                }

                animals.add(animal);

            } else {
                String[] foodInfo = input.split("\\s+");
                String foodType = foodInfo[0];
                Integer foodQuantity = Integer.parseInt(foodInfo[1]);

                switch (foodType) {
                    case "Vegetable":
                        food = new Vegetable(foodQuantity);
                        break;
                    case "Meat":
                        food = new Meat(foodQuantity);
                        break;
                }

                animal.foodEaten = foodQuantity;
            }

            input = sc.nextLine();
            counter++;
        }

        for (Animal a : animals) {
            a.makeSound();
            a.eat(food);
            System.out.println(a);
        }
    }
}
