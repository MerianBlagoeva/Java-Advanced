package Lab.studentsSystem;

public class CommandExecutor {
    private final StudentSystem studentSystem;

    private static final String EXIT_COMMAND = "Exit";
    private static final String CREATE_STUDENT_COMMAND = "Create";
    private static final String SHOW_STUDENT = "Show";

    public CommandExecutor() {
        this.studentSystem = new StudentSystem();
    }

    public static boolean isExitCommand(String command) {
        return command.equals(EXIT_COMMAND);
    }

    public void executeCommand(String command, String[] data) {

        switch (command) {
            case CREATE_STUDENT_COMMAND:
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                double grade = Double.parseDouble(data[3]);

                studentSystem.createStudent(name, age, grade);
                break;
            case SHOW_STUDENT:
                String studentName = data[1];
                studentSystem.showStudent(studentName);
                String result = studentSystem.showStudent(studentName);

                if (result != null) {
                    System.out.println(result);
                }
                break;
        }

    }
}
