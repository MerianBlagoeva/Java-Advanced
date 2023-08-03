package Exercises.commandParses;

public class FoodShortageCommandHandler extends CommandHandler {

    public FoodShortageCommandHandler(String endCommand, String delimiter) {
        super(endCommand, delimiter);
    }

    @Override
    protected void processNonEndCommand(String[] parameters) {
        System.out.println("Got command: " + parameters[0]);
    }

}
