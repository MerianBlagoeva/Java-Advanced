package Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] numbers = sc.nextLine().split(" ");
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String number : numbers) {
            stack.push(Integer.parseInt(number));
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}