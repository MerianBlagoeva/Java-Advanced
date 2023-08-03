package Exercises.foodShortageAbstractClass;

public class Rebel extends BuyingPerson {
    private String group;


    public Rebel(String name, int age, String group) {
        super(name, age);
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public void buyFood() {
        food += 5;
    }
}
