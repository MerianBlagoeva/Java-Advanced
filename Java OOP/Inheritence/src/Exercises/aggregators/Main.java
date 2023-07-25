package Exercises.aggregators;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String type = sc.nextLine();

        Aggregator aggregator;

        switch (type) {
            case "average":
                aggregator = new AverageAggregator();
                break;
            case "min":
                aggregator = new MinAggregator();
                break;
            case "sum":
                aggregator = new SumAggregator();
                break;
            case "multiply":
                aggregator = new MultiplyAggregator();
                break;
            default:
                throw new IllegalStateException("Unknown type " + type);
        }

        String[] numbersAsStrings = sc.nextLine().split("\\s+");
        for (String s : numbersAsStrings) {
            aggregator.add(Integer.parseInt(s));
        }

        System.out.println(aggregator.getCurrentAggregation());
    }
}
