package Exercises.foodShortageAbstractClass;

import java.util.List;

public class FoodShortageHandler extends CommandHandler {

    private final List<BuyingPerson> buyingPeople;

    public FoodShortageHandler(List<BuyingPerson> buyingPeople, String endCommand, String delimiter) {
        super(endCommand, delimiter);
        this.buyingPeople = buyingPeople;
    }

    @Override
    protected void processNonEndCommand(String name) {
        buyingPeople.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst().ifPresent(BuyingPerson::buyFood);
    }
}
