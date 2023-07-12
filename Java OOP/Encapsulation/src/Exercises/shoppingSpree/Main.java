package Exercises.shoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Person> people;
        List<Product> products;
        try {
            people = parsePeople(sc.nextLine());
            products = parseProducts(sc.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String action = sc.nextLine();

        while (!action.equals("END")) {
            String[] data = action.split(" ");
            Person person = people.stream().filter(p -> p.getName().equals(data[0]))
                    .findFirst().get();

            Product product = products.stream().filter(p -> p.getName().equals(data[1]))
                    .findFirst().get();

            try {
                person.buyProduct(product);
                System.out.println(person.getName() + " bought " + product.getName());

            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }

            action = sc.nextLine();
        }

        for (Person person : people) {
            List<Product> personProducts = person.getProducts();
            System.out.print(person.getName() + " - ");
            if (personProducts.isEmpty()) {
                System.out.println("Nothing bought");
            } else {
                List<String> productNames = new ArrayList<>();
                personProducts.forEach(product -> productNames.add(product.getName()));
                System.out.println(String.join(", ", productNames));
            }

        }
    }

    private static List<Product> parseProducts(String productString) {
        List<Product> products = new ArrayList<>();
        String[] productAsString = productString.split(";");
        for (String product : productAsString) {
            String[] nameAndCost = product.split("=");
            products.add(new Product(nameAndCost[0], Double.parseDouble(nameAndCost[1])));
        }

        return products;
    }

    private static List<Person> parsePeople(String peopleString) {

        List<Person> people = new ArrayList<>();
        String[] peopleAsStrings = peopleString.split(";");
        for (String personAsString : peopleAsStrings) {
            String[] nameAndMoney = personAsString.split("=");
            people.add(new Person(nameAndMoney[0], Double.parseDouble(nameAndMoney[1])));
        }
        return people;
    }
}