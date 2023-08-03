package Exercises.foodShortageAbstractClass;

public class Citizen extends BuyingPerson implements Identifiable, Birthable {

    private String id;
    private String birthDate;

    public Citizen(String name, int age, String id, String birthDate) {
        super(name, age);
        this.id = id;
        this.birthDate = birthDate;
    }


    @Override
    public String getId() {
        return id;
    }

    @Override
    public void buyFood() {
        food += 10;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }
}
