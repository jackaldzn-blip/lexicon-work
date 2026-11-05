package se.lexicon.vending;

import java.util.List;
import java.util.Scanner;

public final class Main {
    private Main() { }
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachineImpl(List.of(
            new Snack(1, "Chips", 15, 5, 130),
            new Beverage(2, "Cola", 20, 3, 330),
            new Fruit(3, "Apple", 10, 8, "Sweden")
        ));
        new ConsoleUI(machine, new Scanner(System.in)).start();
    }
}
