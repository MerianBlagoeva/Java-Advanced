package Lab.wildFarmDoesntWork;

public class Tiger extends Feline {
    String livingRegion;

    public Tiger(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
        this.livingRegion = livingRegion;
    }


    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass() != Meat.class) {
            System.out.println(this.getClass().getSimpleName() + "s are not eating that type of food!");
        }
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %.1f, %s, %d]", this.getClass().getSimpleName(), animalName, animalWeight, this.livingRegion, foodEaten);
    }
}
