package Lab.studentsSystem;

public class Student {
    private final String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return this.grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        String studentType = "Very nice person.";

        if (grade >= 5.00) {
            studentType = "Excellent student.";
        } else if (grade < 5.00 && grade >= 3.50) {
            studentType = "Average student.";
        }

        return String.format("%s is %d years old. %s", name, age, studentType);
    }
}
