package Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String parentheses = sc.nextLine();

        ArrayDeque<Character> openingParentheses = new ArrayDeque<>();
        boolean isBalanced = true;

        for (int i = 0; i < parentheses.length(); i++) {
            char currentBracket = parentheses.charAt(i);
            if (currentBracket == '{' || currentBracket == '(' || currentBracket == '[') {
                openingParentheses.push(currentBracket);
            } else {
                if (openingParentheses.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char lastOpeningBracket = openingParentheses.pop();
                if (currentBracket == '}' && lastOpeningBracket != '{') {
                    isBalanced = false;
                    break;
                } else if (currentBracket == ')' && lastOpeningBracket != '(') {
                    isBalanced = false;
                    break;
                } else if (currentBracket == ']' && lastOpeningBracket != '[') {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (isBalanced && openingParentheses.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}