package Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] participants = sc.nextLine().split("\\s+");
        int n = Integer.parseInt(sc.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, participants);

       while (queue.size() > 1) {
           for (int i = 1; i < n; i++) {
               queue.offer(queue.poll());
           }
           System.out.println("Removed " + queue.poll());
       }
        System.out.println("Last is " + queue.poll());
    }
}
