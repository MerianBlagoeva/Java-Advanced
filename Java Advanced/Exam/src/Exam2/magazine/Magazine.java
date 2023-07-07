package Exam2.magazine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Magazine {
    private List<Cloth> data;
    private String type;
    private int capacity;

    public Magazine(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addCloth(Cloth cloth) {
        if (data.size() < capacity) {
            data.add(cloth);
        }
    }

    public boolean removeCloth(String color) {
        return data.removeIf(cloth -> cloth.getColor().equals(color));
    }

    public Cloth getSmallestCloth() {
        return data.stream().min(Comparator.comparingInt(Cloth::getSize)).orElse(null);
    }

    public Cloth getCloth(String color) {
        return data.stream().filter(cloth -> cloth.getColor().equals(color)).findFirst().orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder(type + " exam2.magazine contains:").append(System.lineSeparator());
        data.forEach(cloth -> sb.append(cloth).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
