package Exercises.foodShortageAbstractClass;

public abstract class BuyingPerson implements Person, Buyer {
    private String name;
    private int age;
    protected int food;

    public BuyingPerson(String name, int age) {
        this.name = name;
        this.age = age;
        this.food = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public abstract void buyFood();
}
