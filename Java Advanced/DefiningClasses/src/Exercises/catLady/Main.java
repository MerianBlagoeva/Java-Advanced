package Exercises.catLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();

        Map<String, Cat> cats = new HashMap<>();

        while (!command.equals("End")) {
            String[] catData = command.split("\\s+");

            String breed = catData[0];
            String name = catData[1];
            Cat cat = null;

            switch (breed) {
                case "Siamese":
                    double earSize = Double.parseDouble(catData[2]);
                    cat = new Siamese(name, earSize);
                    break;
                case "Cymric":
                    double furLength = Double.parseDouble(catData[2]);
                    cat = new Cymric(name, furLength);
                    break;
                case "StreetExtraordinaire":
                    double decibels = Double.parseDouble(catData[2]);
                    cat = new StreetExtraordinaire(name, decibels);

                    break;
            }
            cats.put(name, cat);
            command = sc.nextLine();
        }
        String catNameToSearch = sc.nextLine();
        if (cats.containsKey(catNameToSearch)) {
            System.out.println(cats.get(catNameToSearch));
        }
    }
}