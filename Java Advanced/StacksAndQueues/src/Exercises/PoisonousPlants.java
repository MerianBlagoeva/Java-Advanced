package Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class PoisonousPlants { //преписана
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] plants = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] days = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int max = -1;
        for (int i = 1; i < plants.length; i++) {
            int maxDays = 0;
            while (stack.size() > 0 && plants[stack.peek()] >= plants[i]) {
                maxDays = Math.max(days[stack.pop()], maxDays);
            }
            if (stack.size() > 0) {
                days[i] = maxDays + 1;
                if (maxDays + 1 > max) {
                    max = maxDays + 1;
                }
            }
            stack.push(i);
        }
        System.out.println(max);
    }
}
