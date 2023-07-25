package Exercises.aggregators;

public class MinAggregator extends Aggregator {

    public MinAggregator() {
        this.currentAggregation = Integer.MAX_VALUE;
    }

    @Override
    public void add(int number) {
        if (number < this.currentAggregation) {
            this.currentAggregation = number;
        }
    }
}
