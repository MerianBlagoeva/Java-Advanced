package Lab;

import java.util.Scanner;

public class AcademyGraduation2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            double sum = 0;
            int count = 0;
            while (sc.hasNextDouble()) {
                double score = sc.nextDouble();
                sum += score;
                count++;
            }
            double average = sum / count;
            System.out.println(name + " is graduated with " + average);
        }
    }
}
