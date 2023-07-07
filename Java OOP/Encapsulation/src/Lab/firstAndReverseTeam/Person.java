package Lab.firstAndReverseTeam;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        ensureNameLength(firstName, "First");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        ensureNameLength(lastName, "Last");
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 1) {
            throw new IllegalStateException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalStateException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public void ensureNameLength(String name, String messagePrefix) {
        if (name.length() < 3) {
            throw new IllegalStateException(messagePrefix + " name cannot be less than 3 symbols");
        }
    }

    public void increaseSalary(double bonusPercentage) {
        double bonusPercentageReduced = age < 30 ? bonusPercentage / 2 : bonusPercentage;

        salary += salary * (bonusPercentageReduced / 100);
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %f leva.", firstName, lastName, salary);
    }
}
