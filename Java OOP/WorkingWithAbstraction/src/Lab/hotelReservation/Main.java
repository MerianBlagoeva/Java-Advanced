package Lab.hotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(input[0]);
        int numberOfDays = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2]);
        Discount discount = Discount.valueOf(input[3]);

        double finalPrice = PriceCalculator.calculatePrice(pricePerDay, numberOfDays, season, discount);

        System.out.printf("%.2f", finalPrice);
    }
}
