package Exercises.aggregators;

public class SumAggregator extends Aggregator {

    @Override
    public void add(int number) {
        currentAggregation += number;
    }
}
