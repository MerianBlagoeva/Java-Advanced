package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();

        String currentURL = "Blank";
        ArrayDeque<String> history = new ArrayDeque<>();

        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (!history.isEmpty()) {
                    currentURL = history.pop();
                } else {
                    System.out.println("no previous URLs");
                    command = sc.nextLine();
                    continue;
                }
            } else {
                if (!currentURL.equals("Blank")) {
                    history.push(currentURL);
                }
                currentURL = command;
            }
            System.out.println(currentURL);
            command = sc.nextLine();
        }
    }
}
