package Exercises.cardRank;

import java.util.Arrays;

public class Main {
    enum CardRank {
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING
    }

    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        Arrays.stream(CardRank.values())
                .forEach(value -> System.out.println("Ordinal value: " + value.ordinal() + "; Name value: " + value));
    }
}
