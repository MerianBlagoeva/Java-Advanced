package ObjectsAndClassesExamExercises.shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (data.size() < capacity) {
            data.add(animal);
        }
    }
    public boolean remove(String name) {
        return data.removeIf(animal -> animal.getName().equals(name));
    }

    public Animal getAnimal(String name, String caretaker) {
        return data.stream().filter(animal -> animal.getName().equals(name) && animal.getCaretaker().equals(caretaker))
                .findFirst().orElse(null);
    }

    public Animal getOldestAnimal() {
        return data.stream().max(Comparator.comparingInt(Animal::getAge)).orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder("The ObjectsAndClassesExamExercises.shelter has the following animals:").append(System.lineSeparator());
        data.forEach(animal -> sb.append(animal.getName())
                .append(" ")
                .append(animal.getCaretaker())
                .append(System.lineSeparator()));

        return sb.toString().trim();
    }
}