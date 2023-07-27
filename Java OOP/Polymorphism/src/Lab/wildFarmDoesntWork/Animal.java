package Lab.wildFarmDoesntWork;

public abstract class Animal {
    protected String animalType;
    protected String animalName;
    protected Double animalWeight;
    protected Integer foodEaten;

    public Animal(String animalName, Double animalWeight) {
        this.animalName = animalName;
        this.animalWeight = animalWeight;
    }
    public abstract void makeSound();

    public abstract void eat(Food food);

    @Override
    public String toString() {
        return String.format("%s[%s, %.1f, %d]", this.getClass().getSimpleName(), animalName, animalWeight, foodEaten);
    }
}
