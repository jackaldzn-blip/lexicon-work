package se.lexicon.vending;

public final class Fruit extends Product {
    private final String origin;

    public Fruit(int id, String name, int price, int quantity, String origin) {
        super(id, name, price, quantity);
        if (origin == null || origin.isBlank()) throw new IllegalArgumentException("Origin is required");
        this.origin = origin.strip();
    }

    public String getOrigin() { return origin; }
    @Override public String getDescription() {
        return getName() + " (Fruit, " + origin + ")";
    }
}
