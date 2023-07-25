package Exercises.aggregators;

public class AverageAggregator extends Aggregator {
    double currentFloatingPointAverage = 0;
    int totalNumbers = 0;
    @Override
    public void add(int number) {
        currentFloatingPointAverage = (currentFloatingPointAverage * totalNumbers + number) / totalNumbers + 1;
        totalNumbers++;

        this.currentAggregation = (int)currentFloatingPointAverage;
    }
}
