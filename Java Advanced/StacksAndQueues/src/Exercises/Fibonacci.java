package Exercises;

public class Fibonacci {

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    // return the nth element of the Fibonacci sequence
    public static void main(String[] args) {
        int n = 5;  // specify the value of n here
        int result = fibonacci(n);
        System.out.println("The Fibonacci number for " + n + " is " + result);
    }
}
