package Lab.genericArrayCreator;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = ArrayCreator.<Integer>create(Integer.class, 5, 13);

        String[] strings = ArrayCreator.create(5, "Java-Generics");

        for (int i : arr) {
            System.out.print(i + " ");
        }

        for (String s : strings) {
            System.out.print(s + " ");
        }
    }
}
