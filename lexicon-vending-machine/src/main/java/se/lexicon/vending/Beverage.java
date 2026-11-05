package se.lexicon.vending;

public final class Beverage extends Product {
    private final int volumeMl;

    public Beverage(int id, String name, int price, int quantity, int volumeMl) {
        super(id, name, price, quantity);
        if (volumeMl <= 0) throw new IllegalArgumentException("Volume must be positive");
        this.volumeMl = volumeMl;
    }

    public int getVolumeMl() { return volumeMl; }
    @Override public String getDescription() {
        return getName() + " (Beverage, " + volumeMl + "ml)";
    }
}
