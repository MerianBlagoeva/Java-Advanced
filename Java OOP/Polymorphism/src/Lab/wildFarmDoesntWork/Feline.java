package Lab.wildFarmDoesntWork;

public abstract class Feline extends Mammal{


    public Feline(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public abstract void makeSound();

    @Override
    public abstract void eat(Food food);
}
