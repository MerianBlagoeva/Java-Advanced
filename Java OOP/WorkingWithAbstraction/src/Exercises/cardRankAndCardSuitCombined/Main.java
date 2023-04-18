package Exercises.cardRankAndCardSuitCombined;

import java.util.Scanner;

public class Main {
    enum CardRanks {
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

    enum CardSuits {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }

    static <E extends Enum<E>> void printEnumOrdinalsAndNames(Enum<E>[] values) {
        for (Enum<E> value : values) {
            System.out.println("Ordinal value: " + value.ordinal() + "; Name value: " + value);
        }
    }

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        System.out.println(input + ":");

        if (input.equals("Card Ranks")) {
            printEnumOrdinalsAndNames(CardRanks.values());
        } else {
            printEnumOrdinalsAndNames(CardSuits.values());
        }
    }
}
