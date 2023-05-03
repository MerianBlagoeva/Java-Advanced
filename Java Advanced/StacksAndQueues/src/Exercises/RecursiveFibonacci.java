package Exercises;

import java.util.Scanner;

public class RecursiveFibonacci { //with memorisation
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        memory = new long[n + 1];
        System.out.println(fib(n));

    }

    public static long fib(int n) {
        if (n < 2) {
            return 1;
        }
        if (memory[n] != 0) {
            return memory[n];
        }
        memory[n] =  fib(n - 1) + fib(n - 2);
        return memory[n];
    }
    public static long[] memory;
}