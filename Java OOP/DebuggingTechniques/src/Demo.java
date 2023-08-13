import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


    /*
Input:
Joro 31
Miro 12
Pesho 32
Tommy 31
Michelle 28
end
31


    Output:
    Joro
    Tommy


Input:
Joro -31
Joro 31
Miro 12
Pesho -32
Pesho 32
Tommy 32
Michelle 28
end
31


    Output:
    Age must be positive try again
    Age must be positive try again
    Joro
    Tommy

     */

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Person> people = readPeople(sc);

        int searchAge = Integer.parseInt(sc.nextLine());

        List<Person> searchResultPeople = searchPeopleByAge(people, searchAge);

        printPeopleNames(searchResultPeople);

    }

    private static List<Person> searchPeopleByAge(List<Person> people, int searchAge) {
        List<Person> searchResultPeople = new ArrayList<>();

        for (Person person : people) {
            if (searchAge == person.getAge()) {
                searchResultPeople.add(person);
            }
        }
        return searchResultPeople;
    }

    private static List<Person> readPeople(Scanner sc) {
        String line = sc.nextLine();
        List<Person> people = new ArrayList<>();
        while (!line.equals("end")) {

            Person person = tryParsePerson(line);

            if (person != null) {
                people.add(person);
            } else {
                System.out.println("Invalid input. Please try again.");
            }

            line = sc.nextLine();
        }

        return people;
    }

    private static Person tryParsePerson(String personString) {
        String[] personNameAndAgeStrings = personString.split("\\s+");

        String name = personNameAndAgeStrings[0];
        int age = Integer.parseInt(personNameAndAgeStrings[1]);

//        if (age < 0) {
//            return null;
//        }

        return new Person(name, age);
    }

    private static void printPeopleNames(List<Person> people) {
        for (Person person : people) {
            System.out.println(person.getName());
        }
    }

}
