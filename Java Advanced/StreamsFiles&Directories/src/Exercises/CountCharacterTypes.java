package Exercises;

import java.io.*;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        FileReader fileReader = new FileReader("resources/input.txt");
        PrintWriter printWriter = new PrintWriter(new FileWriter("resources\\output.txt"));
        int oneByte = fileReader.read();
        while (oneByte != -1) {
            char symbol = (char) oneByte;

            if (isVowel(symbol)) {
                vowels++;
            } else if (isPunctuation(symbol)) {
                punctuation++;
            } else if (!Character.isWhitespace(symbol)) {
                consonants++;
            }
            oneByte = fileReader.read();
        }

        fileReader.close();
        printWriter.println("Vowels: " + vowels);
        printWriter.println("Other symbols: " + consonants);
        printWriter.println("Punctuation: " + punctuation);
        printWriter.close();
    }

    private static boolean isPunctuation(char symbol) {
        return symbol == '!' || symbol == '?' || symbol == '.' || symbol == ',';
    }

    private static boolean isVowel(char symbol) {
        return symbol == 'a'
               || symbol == 'e'
               || symbol == 'i'
               || symbol == 'o'
               || symbol == 'u';
    }
}
