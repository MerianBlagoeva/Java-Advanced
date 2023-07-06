package ObjectsAndClassesExamExercises.parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public int getCapacity() {
        return capacity;
    }
    public void add(Parrot parrot) {
        if (data.size() < capacity) {
            data.add(parrot);
        }
    }
    public boolean remove(String name) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(name)) {
                data.remove(i);
                return true;
            }
        }
        return false;
    }
    public Parrot sellParrot(String name) {
        Parrot soldParrot = null;
        for (Parrot parrot : data) {
            if (parrot.getName().equals(name)) {
                parrot.setAvailable(false);
                soldParrot = parrot;
            }
        }
        return soldParrot;
    }
    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> soldParrots = new ArrayList<>();
        data.forEach(p -> {
            if (p.getSpecies().equals(species)) {
                soldParrots.add(p);
                p.setAvailable(false);
            }
        });
        return soldParrots;
    }
    public int count() {
        return data.size();
    }
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parrots available at ").append(name).append(":").append(System.lineSeparator());
        data.stream()
                .filter(Parrot::isAvailable)
                .forEach(p -> sb.append(p).append(System.lineSeparator()));
        return sb.toString();
    }
}
