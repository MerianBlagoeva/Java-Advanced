package Exercises;

import java.util.Collection;

public abstract class Calculator<T> {
    public double sum(Iterable<T> products) {
        double sum = 0;
        for (T t : products) {
            sum += extractValue(t);
        }

        return sum;
    }

    public double average(Collection<T> products) {
        return sum(products) / products.size();
    }

    protected abstract double extractValue(T t);
}
