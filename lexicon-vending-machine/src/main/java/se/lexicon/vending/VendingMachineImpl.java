package se.lexicon.vending;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class VendingMachineImpl implements VendingMachine {
    private static final Set<Integer> VALID_COINS = Set.of(1, 2, 5, 10, 20, 50);
    private final List<Product> products;
    private int balance;
    private int lastReturnedChange;

    public VendingMachineImpl(List<Product> products) {
        if (products == null) throw new IllegalArgumentException("Products are required");
        Set<Integer> ids = new HashSet<>();
        for (Product product : products) {
            if (product == null || !ids.add(product.getId()))
                throw new IllegalArgumentException("Products must be non-null with unique IDs");
        }
        this.products = new ArrayList<>(products);
    }

    @Override public boolean insertCoin(int coin) {
        if (!VALID_COINS.contains(coin)) return false;
        balance = Math.addExact(balance, coin);
        return true;
    }

    @Override public Product purchaseProduct(int id) {
        Product product = products.stream()
            .filter(item -> item.getId() == id)
            .findFirst()
            .orElseThrow(() -> new PurchaseException("Product not found: " + id));
        if (product.getQuantity() == 0) throw new PurchaseException(product.getName() + " is out of stock.");
        if (balance < product.getPrice()) {
            throw new PurchaseException("Insufficient balance. " + product.getName() + " costs "
                + product.getPrice() + " kr. Missing " + (product.getPrice() - balance) + " kr.");
        }
        product.dispenseOne();
        balance -= product.getPrice();
        lastReturnedChange = returnChange(); // Assignment: automatically return remaining balance.
        return product;
    }

    @Override public int returnChange() {
        int change = balance;
        balance = 0;
        return change;
    }

    @Override public int getBalance() { return balance; }
    @Override public int getLastReturnedChange() { return lastReturnedChange; }
    @Override public List<Product> getProducts() { return List.copyOf(products); }
}
