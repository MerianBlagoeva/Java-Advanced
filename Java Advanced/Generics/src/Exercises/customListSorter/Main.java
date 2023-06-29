package Exercises.customListSorter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();
        CustomList<String> list = new CustomList<>();

        while (!command.equals("END")) {
            String[] commandParts = command.split(" ");
            String commandType = commandParts[0];

            switch (commandType) {
                case "Add":
                    list.add(commandParts[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(commandParts[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(commandParts[1]));
                    break;
                case "Swap":
                    int index1 = Integer.parseInt(commandParts[1]);
                    int index2 = Integer.parseInt(commandParts[2]);
                    list.swap(index1, index2);
                    break;
                case "Greater":
                    String element = commandParts[1];
                    System.out.println(list.greater(element));
                    break;
                case "Max":
                    System.out.println(list.max());
                    break;
                case "Min":
                    System.out.println(list.min());
                    break;
                case "Sort":
                    Sorter.sort(list);
                    break;
                case "Print":
                    System.out.println(list);
                    break;
            }
            command = sc.nextLine();
        }
    }
}
