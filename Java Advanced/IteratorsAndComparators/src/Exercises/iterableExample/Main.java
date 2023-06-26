package Exercises.iterableExample;

public class Main {
    public static void main(String[] args) {

        Shelf shelf = new Shelf("Apple", "Banana", "Pear", "Watermelon");
        for (String s : shelf) {
            System.out.println(s);
        }
    }
}
