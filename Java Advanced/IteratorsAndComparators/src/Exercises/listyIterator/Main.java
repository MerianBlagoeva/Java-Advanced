package Exercises.listyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        ListyIterator listyIterator = null;

        while (!input.equals("END")) {
            String[] inputParts = input.split("\\s+");
            String command = inputParts[0];


            switch (command) {
                case "Create":
                    if (inputParts.length > 1) {
                        String[] elementsArray = Arrays.copyOfRange(inputParts, 1, inputParts.length);
                        listyIterator = new ListyIterator(elementsArray);
                    } else {
                        listyIterator = new ListyIterator();
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
            }

            input = sc.nextLine();
        }
    }
}