package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();

        String currentURL = "Blank";
        ArrayDeque<String> historyStack = new ArrayDeque<>();
        ArrayDeque<String> forwardQueue = new ArrayDeque<>();


        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (!historyStack.isEmpty()) {

                    currentURL = historyStack.pop();


                } else {
                    System.out.println("no previous URLs");
                    command = sc.nextLine();
                    continue;
                }
            } else if (command.equals("forward")) {
                currentURL = forwardQueue.poll();

            } else {
                if (!currentURL.equals("Blank")) {
                    historyStack.push(currentURL);
                }

                currentURL = command;
            }
            System.out.println(currentURL);
            command = sc.nextLine();
        }
    }
}

