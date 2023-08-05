package barracksWars.core.commands;

import barracksWars.annotations.Inject;
import barracksWars.interfaces.CommandInterpreter;
import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private final Repository repository;
    private final UnitFactory unitFactory;
    public final static String COMMAND_PACKAGE = "barracksWars.core.commands.";

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        String className = parseCommandToClassName(commandName);
        Executable command = null;
        try {
            Class clazz = Class.forName(className);
            Constructor<Command> constructor = clazz.getDeclaredConstructors()[0];

            command = constructor.newInstance(new Object[]{data});
            //Inject
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Inject.class)) {
                    if (field.getType().equals(Repository.class)) {
                        field.setAccessible(true);
                        field.set(command, repository);
                    } else if (field.getType() == UnitFactory.class) {
                        field.setAccessible(true);
                        field.set(command, unitFactory);
                    }
                }
            }

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return command;

    }

    private String parseCommandToClassName(String commandName) {
        String firstLetterUppercase = commandName.substring(0, 1).toUpperCase();
        String restOfTheCommand = commandName.substring(1);

       return COMMAND_PACKAGE + firstLetterUppercase + restOfTheCommand + "Command";
    }
}
