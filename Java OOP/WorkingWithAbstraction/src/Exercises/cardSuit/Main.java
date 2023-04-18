package Exercises.cardSuit;

import java.util.Arrays;

public class Main {
    enum CardSuits {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }
    public static void main(String[] args) {
        System.out.println("Card Suits:");
        CardSuits[] values = CardSuits.values();
        Arrays.stream(values)
                .forEach(value -> System.out.println("Ordinal value: " + value.ordinal() + "; Name value: " + value));
    }
}
