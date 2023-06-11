package Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        String path = "resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("output.txt");

        PrintWriter printer = new PrintWriter(outputStream);

        int oneByte = inputStream.read();

        Set<Integer> delimiterTable = Set.of(10, 32);
        while (oneByte != -1) {

            boolean isDelimiter = delimiterTable.contains(oneByte);

            if (isDelimiter) {
               printer.print((char) oneByte);
            } else {
                printer.print(oneByte);
            }

            oneByte = inputStream.read();
        }
        inputStream.close();
        outputStream.close();
    }
}

