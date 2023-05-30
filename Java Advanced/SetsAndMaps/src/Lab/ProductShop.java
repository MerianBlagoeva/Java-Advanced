package Lab;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Map<String, LinkedHashMap<String, Double>> shops = new TreeMap<>();


        while (!input.equals("Revision")) {
            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            LinkedHashMap<String, Double> products = new LinkedHashMap<>();

            if (shops.containsKey(shop)) {
                products = shops.get(shop);
            }
            products.put(product, price);
            shops.put(shop, products);

            input = sc.nextLine();
        }
        for (String shop : shops.keySet()) {
            System.out.println(shop + "->");
            LinkedHashMap<String, Double> products = shops.get(shop);
            for (String product : products.keySet()) {
                System.out.printf("Product: %s, Price: %.1f\n", product, products.get(product));
            }
        }
    }
}
