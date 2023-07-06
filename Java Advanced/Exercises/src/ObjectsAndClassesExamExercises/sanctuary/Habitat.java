package ObjectsAndClassesExamExercises.sanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat {
    private List<Elephant> data;

    private int capacity;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if (data.size() < capacity) {
            data.add(elephant);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(elephant -> elephant.getName().equals(name));
    }

    public Elephant getElephant(String retiredFrom) {
        return data.stream().filter(elephant -> elephant.getRetiredFrom().equals(retiredFrom)).findFirst().orElse(null);
    }
    public Elephant getOldestElephant() {
        return data.stream().max(Comparator.comparingInt(Elephant::getAge)).orElse(null);
    }
    public int getAllElephants() {
        return data.size();
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder("Saved elephants in the park:").append(System.lineSeparator());
        data.forEach(elephant -> sb.append(elephant.getName())
                .append(" ")
                .append("came from: ")
                .append(elephant.getRetiredFrom())
                .append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
