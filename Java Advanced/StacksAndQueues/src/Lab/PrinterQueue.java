package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String fileName = sc.nextLine();
        ArrayDeque<String> printerQueue= new ArrayDeque<>();

        while (!fileName.equals("print")) {

            if (fileName.equals("cancel")) {
                if (printerQueue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + printerQueue.poll());
                }
            } else {
                printerQueue.offer(fileName);
            }

            fileName = sc.nextLine();
        }
//        for (String file : printerQueue) {
//            System.out.println(file);
//        }
        while (!printerQueue.isEmpty()) {
            System.out.println(printerQueue.poll());
        }
    }
}
