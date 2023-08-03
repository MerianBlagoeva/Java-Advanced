package Exercises;

import Exercises.products.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        CalorieCalculator caloriesCalculator = new CalorieCalculator();

        ArrayList<Product> products = new ArrayList<>();

        products.add(new Coke(500));
        products.add(new Lemonade(330));
        products.add(new Chocolate(100));
        products.add(new Chips(200));

        ValuePrinter valuePrinter = new ValuePrinter();

        valuePrinter.printSum(caloriesCalculator.sum(products));
        valuePrinter.printAverage(caloriesCalculator.average(products));

        QuantityCalculator<Product> quantityCalculator = new QuantityCalculator<>();

        valuePrinter.printSum(quantityCalculator.sum(products));
        valuePrinter.printAverage(quantityCalculator.average(products));

    }
}
