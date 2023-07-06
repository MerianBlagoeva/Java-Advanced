package ObjectsAndClassesExamExercises.easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {
    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (data.size() < capacity) {
            data.add(egg);
        }
    }

//    public boolean removeEgg(String color) {
//        Egg egg = this.getEgg(color);
//        data.remove(egg);
//        return egg != null;
//    }

    public boolean removeEgg(String color) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getColor().equals(color)) {
                data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Egg getStrongestEgg() {
        return data.stream().max(Comparator.comparingInt(Egg::getStrength)).orElse(null);
    }

    public Egg getEgg(String color) {
        return data.stream().filter(e -> e.getColor().equals(color)).findFirst().orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(material).append(" basket contains:").append(System.lineSeparator());
        data.forEach(egg -> sb.append(egg).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
