package Exercises.genericCountMethodDouble;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Box<Double> box = new Box<>();

        for (int i = 0; i < n; i++) {
            Double element = Double.parseDouble(sc.nextLine());
            box.add(element);
        }

        Double elementToCompare = Double.parseDouble(sc.nextLine());
        System.out.println(box.countOfGreaterElements(elementToCompare));
    }
}
