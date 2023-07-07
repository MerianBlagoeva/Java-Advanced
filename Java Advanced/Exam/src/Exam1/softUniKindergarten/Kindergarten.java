package Exam1.softUniKindergarten;

import java.util.ArrayList;
import java.util.List;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (registry.size() < capacity) {
            registry.add(child);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeChild(String firstName) {
        for (Child child : registry) {
            if (child.getFirstName().equals(firstName)) {
                registry.remove(child);
                return true;
            }
        }
        return false;
    }

    public int getChildrenCount() {
        return registry.size();
    }

    public Child getChild(String firstName) {
        for (Child child : registry) {
            if (child.getFirstName().equals(firstName)) {
                return child;
            }
        }
        return null;
    }

    public String registryReport() {
        registry.sort((c1, c2) -> {
            int result = Integer.compare(c1.getAge(), c2.getAge());
            if (result == 0) {
                result = c1.getFirstName().compareTo(c2.getFirstName());
                if (result == 0) {
                    result = c1.getLastName().compareTo(c2.getLastName());
                }
            }
            return result;
        });
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Registered children in %s:", name)).append(System.lineSeparator());
        for (Child child : registry) {
            sb.append("--").append(System.lineSeparator());
            sb.append(child.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}