package Exercises.birthdayCelebrations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BirthdayCelebrationsHandler handler = new BirthdayCelebrationsHandler("End", "\\s+");

        handler.readAndHandleCommandsToEnd(sc);

        String birthYear = sc.nextLine();

        for (Birthable b : handler.getAllBirthable()) {
            if (b.getBirthDate().endsWith(birthYear)) {
                System.out.println(b.getBirthDate());
            }
        }
    }
}