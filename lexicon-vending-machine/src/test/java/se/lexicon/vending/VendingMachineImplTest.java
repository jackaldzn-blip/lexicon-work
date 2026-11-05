package se.lexicon.vending;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class VendingMachineImplTest {
    private final Snack chips = new Snack(1, "Chips", 15, 5, 130);
    private final Beverage cola = new Beverage(2, "Cola", 20, 3, 330);
    private final Fruit apple = new Fruit(3, "Apple", 10, 8, "Sweden");
    private VendingMachineImpl machine() { return new VendingMachineImpl(List.of(chips, cola, apple)); }

    @Test void validCoinIncreasesBalance() {
        var machine = machine();
        assertTrue(machine.insertCoin(10));
        assertEquals(10, machine.getBalance());
    }
    @Test void invalidCoinDoesNotChangeBalance() {
        var machine = machine();
        assertFalse(machine.insertCoin(7));
        assertEquals(0, machine.getBalance());
    }
    @Test void successfulPurchaseReturnsProductAndReducesStock() {
        var machine = machine();
        machine.insertCoin(20);
        assertSame(cola, machine.purchaseProduct(2));
        assertEquals(0, machine.getBalance());
        assertEquals(2, cola.getQuantity());
    }
    @Test void insufficientBalancePreservesMoneyAndStock() {
        var machine = machine();
        machine.insertCoin(10);
        assertThrows(PurchaseException.class, () -> machine.purchaseProduct(2));
        assertEquals(10, machine.getBalance());
        assertEquals(3, cola.getQuantity());
    }
    @Test void outOfStockPreservesMoneyAndStock() {
        var empty = new Beverage(2, "Cola", 20, 0, 330);
        var machine = new VendingMachineImpl(List.of(empty));
        machine.insertCoin(20);
        assertThrows(PurchaseException.class, () -> machine.purchaseProduct(2));
        assertEquals(20, machine.getBalance());
        assertEquals(0, empty.getQuantity());
    }
    @Test void returnChangeResetsBalance() {
        var machine = machine();
        machine.insertCoin(50);
        assertEquals(50, machine.returnChange());
        assertEquals(0, machine.getBalance());
    }
    @Test void returnsAllProducts() {
        assertEquals(3, machine().getProducts().size());
    }
    @Test void excessPaymentIsAutomaticallyReturned() {
        var machine = machine();
        machine.insertCoin(20);
        machine.purchaseProduct(1);
        assertEquals(5, machine.getLastReturnedChange());
        assertEquals(0, machine.getBalance());
    }
    @Test void missingProductDoesNotChangeBalance() {
        var machine = machine();
        machine.insertCoin(10);
        assertThrows(PurchaseException.class, () -> machine.purchaseProduct(99));
        assertEquals(10, machine.getBalance());
    }
    @Test void rejectDuplicateProductIds() {
        assertThrows(IllegalArgumentException.class, () -> new VendingMachineImpl(List.of(
            new Snack(1, "Chips", 15, 5, 130), new Fruit(1, "Apple", 10, 2, "Sweden"))));
    }
    @Test void rejectInvalidProductsAndProtectProductList() {
        assertThrows(IllegalArgumentException.class, () -> new Snack(1, "Chips", 0, 3, 100));
        assertThrows(IllegalArgumentException.class, () -> new Fruit(1, "Apple", 10, -1, "Sweden"));
        assertThrows(UnsupportedOperationException.class, () -> machine().getProducts().clear());
    }
    @Test void productDescriptionsUsePolymorphism() {
        assertEquals("Chips (Snack, 130g)", chips.getDescription());
        assertEquals("Cola (Beverage, 330ml)", cola.getDescription());
        assertEquals("Apple (Fruit, Sweden)", apple.getDescription());
    }
}
