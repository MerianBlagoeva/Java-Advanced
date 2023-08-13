public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age must be positive, try again");
        }

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
