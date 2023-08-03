package Exercises.militaryElite;

public class SoldierImpl implements Soldier{
    private int id;
    private String firstName;
    private String lastName;


    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }
}
