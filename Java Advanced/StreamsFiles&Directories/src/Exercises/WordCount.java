package Exercises;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) throws IOException {
        //Read words from word.txt
        //Put them in a LinkedHashMap
        //Read text from text.txt
        //Count the occurrences of each word and print it in result.txt

        Scanner wordScanner = new Scanner(new FileReader("resources/words.txt"));
        String[] wordsToSearch = wordScanner.nextLine().split(" ");

        Map<String, Integer> occurrences = new LinkedHashMap<>();
        for (String word: wordsToSearch) {
            occurrences.putIfAbsent(word.toLowerCase(), 0);

        }
        Scanner fileScanner = new Scanner(new FileReader("resources/text.txt"));
        String singleWord = fileScanner.next().toLowerCase();
        while (fileScanner.hasNext()) {
            if (occurrences.containsKey(singleWord)) {
                int currentWordOccurrences = occurrences.get(singleWord);
                currentWordOccurrences++;
                occurrences.put(singleWord, currentWordOccurrences);
            }
            singleWord = fileScanner.next();
        }
        PrintWriter pw = new PrintWriter(new FileWriter("resources/result.txt"));
       occurrences.entrySet().stream().sorted((f, s) -> s.getValue() - f.getValue())
                       .forEach(entry -> pw.println(entry.getKey() + " - " + entry.getValue()));

        fileScanner.close();
        wordScanner.close();
        pw.close();
    }
}
