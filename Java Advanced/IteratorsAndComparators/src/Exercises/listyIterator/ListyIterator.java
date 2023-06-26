package Exercises.listyIterator;

import java.util.List;

public class ListyIterator {
    private List<String> elements;
    private int index;

    public ListyIterator(String... elements) {
        this.elements = List.of(elements);
        index = 0;
    }

    public boolean hasNext() {
        return index < elements.size() - 1;
    }

    public boolean move() {
        if (hasNext()) {
            index++;
            return true;
        }

        return false;
    }

    public void print() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(elements.get(index));
    }
}
