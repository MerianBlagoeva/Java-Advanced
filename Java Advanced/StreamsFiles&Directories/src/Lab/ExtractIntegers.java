package Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "resources/input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        Scanner sc = new Scanner(inputStream);

        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                System.out.println(sc.nextInt());
            } else {
                sc.next();
            }
        }
    }
}
