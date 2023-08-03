package Exercises.commandParses;

import Exercises.commandParses.animals.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnimalCommandHandler extends CommandHandler {

    private List<Animal> animals;
    public AnimalCommandHandler(String endCommand, String delimiter) {
        super(endCommand, delimiter);
        this.animals = new ArrayList<>();
    }

    @Override
    protected void processNonEndCommand(String[] animalParameters) {

        switch (animalParameters[0]) {
            case "Cat":
                animals.add(new Cat(animalParameters[0], Integer.parseInt(animalParameters[1]), animalParameters[2]));
                break;
            case "Dog":
                animals.add(new Dog(animalParameters[0], Integer.parseInt(animalParameters[1]), animalParameters[2]));
                break;
            case "Frog":
                animals.add(new Frog(animalParameters[0], Integer.parseInt(animalParameters[1]), animalParameters[2]));
                break;
            case "Kitten":
                animals.add(new Kitten(animalParameters[0], Integer.parseInt(animalParameters[1])));
                break;
            case "Tomcat":
                animals.add(new Tomcat(animalParameters[0], Integer.parseInt(animalParameters[1])));
                break;
            default:
                throw new IllegalStateException("Unknown animal type: " + animalParameters[0]);
        }
    }

    public List<Animal> getAnimals() {
        return Collections.unmodifiableList(animals);
    }
}
