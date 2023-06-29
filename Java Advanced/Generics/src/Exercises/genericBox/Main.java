package Exercises.genericBox;

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
        System.out.println(box);
    }
}
