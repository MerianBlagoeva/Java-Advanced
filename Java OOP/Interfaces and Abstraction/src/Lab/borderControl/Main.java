package Lab.borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();

        List<Identifiable> identifiableList = new ArrayList<>();

        while (!command.equals("End")) {
            String[] data = command.split("\\s+");
            Identifiable identifiable;

            if (data.length == 3) {
                identifiable = new Citizen(data[0], Integer.parseInt(data[1]), data[2]);
            } else {
                identifiable = new Robot(data[0], data[1]);
            }

            identifiableList.add(identifiable);

            command = sc.nextLine();
        }
        String fakeIdPostfix = sc.nextLine();

        identifiableList.stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(fakeIdPostfix))
                .forEach(System.out::println);
    }
}