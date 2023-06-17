package Exercises;

import java.io.*;

public class SerializeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Course course = new Course();
        course.name = "Java Advanced";
        course.numberOfStudents = 250;

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("resources/courses.ser"));
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("resources/courses.ser"));

        output.writeObject(course); //serialize -> write to file

        Course courseFromFile = (Course) input.readObject(); //deserialize -> read from file
        System.out.println(courseFromFile.numberOfStudents);
        System.out.println(courseFromFile.name);
    }
}
