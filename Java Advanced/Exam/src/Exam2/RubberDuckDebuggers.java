package Exam2;

import java.util.*;

public class RubberDuckDebuggers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line1 = sc.nextLine();
        String line2 = sc.nextLine();

        ArrayDeque<Integer> time = new ArrayDeque<>();
        ArrayDeque<Integer> numberOfTasks = new ArrayDeque<>();

        Arrays.stream(line1.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(time::offer);

        Arrays.stream(line2.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(numberOfTasks::push);

        Map<String, Integer> ducks = new LinkedHashMap<>();
        ducks.put("Darth Vader Ducky", 0);
        ducks.put("Thor Ducky", 0);
        ducks.put("Big Blue Rubber Ducky", 0);
        ducks.put("Small Yellow Rubber Ducky", 0);

        while (!time.isEmpty() && !numberOfTasks.isEmpty()) {
            int currentTime = time.poll();
            int currentNumberOfTasks = numberOfTasks.pop();

            int result = currentTime * currentNumberOfTasks;

            if (result >= 0 && result <= 60) {
                ducks.put("Darth Vader Ducky", ducks.get("Darth Vader Ducky") + 1);
            } else if (result <= 120) {
                ducks.put("Thor Ducky", ducks.get("Thor Ducky") + 1);
            } else if (result <= 180) {
                ducks.put("Big Blue Rubber Ducky", ducks.get("Big Blue Rubber Ducky") + 1);
            } else if (result <= 240) {
                ducks.put("Small Yellow Rubber Ducky", ducks.get("Small Yellow Rubber Ducky") + 1);
            } else {
                numberOfTasks.push(currentNumberOfTasks - 2);
                time.addLast(currentTime);
            }
        }

        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        ducks.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
