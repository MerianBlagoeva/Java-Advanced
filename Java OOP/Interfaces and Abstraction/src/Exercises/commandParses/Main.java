package Exercises.commandParses;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        FoodShortageCommandHandler commandHandler = new FoodShortageCommandHandler("End", "\\s+");

        commandHandler.readAndHandleCommandsToEnd(sc);

    }
}
