package Lab;

import java.util.*;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tokens = sc.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

//        for (String t : tokens) {
//            stack.push(t);
//        }

        Collections.addAll(stack, tokens);

//        Arrays.stream(tokens).forEach(stack::push);

        while (stack.size() > 1) {
            int first = Integer.parseInt(stack.pop());
            String operation = stack.pop();
            int second = Integer.parseInt(stack.pop());

            switch (operation) {
                case "+" -> stack.push(String.valueOf(first + second));
                case "-" -> stack.push(String.valueOf(first - second));
            }
        }
        System.out.println(stack.pop());
    }
}
