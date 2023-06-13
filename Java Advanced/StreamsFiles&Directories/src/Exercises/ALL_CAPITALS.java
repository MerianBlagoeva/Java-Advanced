package Exercises;

import java.io.*;

public class ALL_CAPITALS {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("resources\\input.txt"));
        PrintWriter printWriter = new PrintWriter(new FileWriter("resources\\output.txt"));

        bufferedReader.lines().forEach(line -> printWriter.println(line.toUpperCase()));
        bufferedReader.close();
        printWriter.close();

    }
}
