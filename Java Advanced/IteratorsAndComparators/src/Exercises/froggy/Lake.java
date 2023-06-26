package Exercises.froggy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private List<Integer> numbers;

    public Lake(Integer... numbers) {
        this.numbers = List.of(numbers);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            //Ако сме извън numbers и индексът ни е четен, променяме индекса на 1
            //Проверяваме дали е четен, защото в противен случай ще обикаля колекцията безкрай, след като обиколи
            // и четните индекси, ще продължи
            if (index >= numbers.size() && index % 2 == 0) {
                index = 1;
            }
            return index < numbers.size();
        }


        @Override
        public Integer next() {
            Integer number = numbers.get(index);
            index += 2;
            return number;
        }
    }
}
