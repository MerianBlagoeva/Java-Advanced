package Lab.p05_DependencyInversion.p03_Database;

public class Courses {
    private final Data database;

    public Courses(Data database) {
        this.database = database;
    }

    public void printAll() {

        Iterable<String> courses = database.courseNames();

        //print courses
    }

    public void printIds() {

        Iterable<Integer> coursesIds = database.courseIds();

        //print course ids
    }

    public void printById(int id) {

        String course = database.getCourseById(id);

        // print course
    }

    public void search(String substring) {

        Iterable<String> courses = database.search(substring);

        // print courses
    }
}
