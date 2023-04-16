package Lab.hotelReservation;

public enum Season {
    Spring(2), Summer(4), Winter(3), Autumn(1);

    private final int multiplier;

    Season(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
