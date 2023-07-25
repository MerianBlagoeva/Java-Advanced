package Exercises.aggregators;

public class MultiplyAggregator extends Aggregator {
    private boolean receivedNumber = false;

    @Override
    public void add(int number) {
        if (!this.receivedNumber) {
            this.currentAggregation = 1;
            this.receivedNumber = true;
        }
        this.currentAggregation *= number;
    }
}
