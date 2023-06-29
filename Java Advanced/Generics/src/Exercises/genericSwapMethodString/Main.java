package Exercises.genericSwapMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Box<String> box = new Box<>();

        for (int i = 0; i < n; i++) {
            String element = sc.nextLine();
            box.add(element);
        }

        String[] indices = sc.nextLine().split("\\s+");
        int firstIndex = Integer.parseInt(indices[0]);
        int secondIndex = Integer.parseInt(indices[1]);
        box.swap(firstIndex, secondIndex);

        System.out.println(box);
    }
}
