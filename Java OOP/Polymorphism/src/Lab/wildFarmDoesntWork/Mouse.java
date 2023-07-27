package Lab.wildFarmDoesntWork;

public class Mouse extends Mammal{


    public Mouse(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass() != Vegetable.class) {
            System.out.println(this.getClass().getSimpleName() + "s are not eating that type of food!");
        }
    }
}
