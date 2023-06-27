package Lab.listUtilities;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(13, 42, 69, 73);

        System.out.println(ListUtils.getMax(numbers));
        System.out.println(ListUtils.getMin(numbers));

        List<String> strings = List.of("a", "Merry", "b", "13", "z");

        System.out.println(ListUtils.getMax(strings));
        System.out.println(ListUtils.getMin(strings));
    }
}
