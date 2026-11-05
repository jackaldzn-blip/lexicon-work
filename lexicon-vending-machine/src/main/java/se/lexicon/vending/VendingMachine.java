package se.lexicon.vending;

import java.util.List;

public interface VendingMachine {
    boolean insertCoin(int coin);
    Product purchaseProduct(int id);
    int returnChange();
    int getBalance();
    int getLastReturnedChange();
    List<Product> getProducts();
}
