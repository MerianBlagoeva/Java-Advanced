package Exercises.telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder result = new StringBuilder();

        for (String number : numbers) {
            if (number.matches("\\d+")) {
                result.append("Calling... ").append(number);
            } else {
                result.append("Invalid number!");
            }
            result.append(System.lineSeparator());
        }

        return result.toString().trim();
    }

    @Override
    public String browse() {

        StringBuilder result = new StringBuilder();

        for (String url : urls) {
            if (url.matches("\\D+")) {
                result.append("Browsing: ").append(url).append("!");
            } else {
                result.append("Invalid URL!");
            }
            result.append(System.lineSeparator());
        }

        return result.toString().trim();
    }
}
