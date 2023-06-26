package Exercises.stragedyPattern;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person first, Person second) {
//        if (first.getName().length() == second.getName().length()) {
//            char letterFirstPerson = first.getName().toLowerCase().charAt(0);
//            char letterSecondPerson = second.getName().toLowerCase().charAt(0);
//            return Character.compare(letterFirstPerson, letterSecondPerson);
//        }

//        return first.getName().length() - second.getName().length();
        return Comparator.comparingInt((Person person) -> person.getName().length())
                .thenComparing(person -> person.getName().toLowerCase().charAt(0))
                .compare(first, second);

    }
}
