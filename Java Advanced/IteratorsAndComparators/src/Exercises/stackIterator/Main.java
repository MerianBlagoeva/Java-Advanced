package Exercises.stackIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] pushCommand = sc.nextLine().split(",\\s+");
        Stack<Integer> stack = new Stack<>();

        String firstCommand = pushCommand[0];
        int firstElement = Integer.parseInt(firstCommand.split("\\s+")[1]);

        stack.push(firstElement);

        for (int i = 1; i < pushCommand.length; i++) {
            int element = Integer.parseInt(pushCommand[i]);
            stack.push(element);
        }

        String command = sc.nextLine();

        while (!command.equals("END")) {
            try {
                stack.pop();
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                return;
            }
            command = sc.nextLine();
        }

        if (!stack.isEmpty()) {
            for (int i = 0; i < 2; i++) {
                for (int element : stack) {
                    System.out.println(element);
                }
            }
        } else {
            System.out.println("No elements");
        }
    }
}
