package Exercises.foodShortageForJudge;

import java.util.Map;

public class FoodShortageHandler extends CommandHandler {

    private final Map<String, Buyer> buyingPeople;

    public FoodShortageHandler(Map<String, Buyer> buyingPeople, String endCommand, String delimiter) {
        super(endCommand, delimiter);
        this.buyingPeople = buyingPeople;
    }

    @Override
    protected void processNonEndCommand(String name) {

        Buyer buyer = findBuyingPerson(name);

        if (buyer != null) {
            buyer.buyFood();
        }
    }

    private Buyer findBuyingPerson(String name) {
        return buyingPeople.get(name);
    }
}
