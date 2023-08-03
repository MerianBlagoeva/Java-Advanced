package Exercises.foodShortageForJudge;

import java.util.Scanner;

public abstract class CommandHandler {
    private final String endCommand;
    private String delimiter;
    public CommandHandler(String endCommand, String delimiter) {
        this.endCommand = endCommand;
        this.delimiter = delimiter;
    }

    public void readAndHandleCommandsToEnd(Scanner sc) {
        boolean reachedEnd = this.handleCommand(sc.nextLine());

        while (!reachedEnd) {
            reachedEnd = this.handleCommand(sc.nextLine());
        }
    }

    public boolean handleCommand(String command) {
        if (command.equals(endCommand)) {
            return true;
        }

        processNonEndCommand(command);

        return false;
    }

    protected abstract void processNonEndCommand(String command);
}
