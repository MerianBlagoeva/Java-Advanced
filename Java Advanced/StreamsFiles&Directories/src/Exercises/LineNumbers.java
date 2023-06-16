package Exercises;

import java.io.*;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("resources/inputLineNumbers.txt"));
        PrintWriter printWriter = new PrintWriter(new FileWriter("resources/output.txt"));
        String line = bufferedReader.readLine();

        int counter = 1;
        while (line != null) {
            printWriter.println(counter + ". " + line);
            counter++;
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        printWriter.close();

    }
}
