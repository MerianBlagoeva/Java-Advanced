package DataStructuresExamExercises;

import java.util.*;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line1 = sc.nextLine();
        String line2 = sc.nextLine();

        ArrayDeque<String> vowels = new ArrayDeque<>();
        ArrayDeque<String> consonants = new ArrayDeque<>();

        Arrays.stream(line1.split("\\s+"))
                .forEach(vowels::offer);

        Arrays.stream(line2.split("\\s+"))
                .forEach(consonants::push);

        Map<String, Set<String>> lettersFound = new LinkedHashMap<>();
        lettersFound.put("pear", new HashSet<>());
        lettersFound.put("flour", new HashSet<>());
        lettersFound.put("pork", new HashSet<>());
        lettersFound.put("olive", new HashSet<>());

        while (!consonants.isEmpty()) {
            String currentVowel = vowels.poll();
            String currentConsonant = consonants.pop();

            lettersFound.forEach((key, value) -> {
                if (key.contains(currentVowel)) {
                    lettersFound.get(key).add(currentVowel);
                }
                if (key.contains(currentConsonant)) {
                    lettersFound.get(key).add(currentConsonant);
                }
            });

            vowels.offer(currentVowel);
        }


        List<String> finalWords = new ArrayList<>();

          lettersFound.entrySet().stream()
                .filter(e -> e.getValue().size() >= e.getKey().length())
                .forEach(e -> finalWords.add(e.getKey()));

        System.out.println("Words found: " + finalWords.size());
        finalWords.forEach(System.out::println);
    }
}
