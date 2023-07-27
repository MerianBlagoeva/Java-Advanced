package Lab.wildFarmDoesntWork;

public class Cat extends Feline {
    private String breed;

    public Cat(String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalWeight, livingRegion);
        this.breed = breed;
    }


    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {

    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %.1f, %s, %d]", this.getClass().getSimpleName(), animalName, breed, animalWeight, livingRegion, foodEaten);
    }
}
