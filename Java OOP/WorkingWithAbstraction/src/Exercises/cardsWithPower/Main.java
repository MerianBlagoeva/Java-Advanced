package Exercises.cardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String rankString = sc.nextLine();
        String suitString = sc.nextLine();

        Card.Rank rank = Card.Rank.valueOf(rankString);
        Card.Suit suit = Card.Suit.valueOf(suitString);
        Card card = new Card(rank, suit);

        System.out.println("Card name: " + card.getName() + "; Card power: " + card.getPower());
    }

}
