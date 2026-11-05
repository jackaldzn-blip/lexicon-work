package se.lexicon.vending;

import java.util.Scanner;

public final class ConsoleUI {
    private final VendingMachine machine;
    private final Scanner scanner;

    public ConsoleUI(VendingMachine machine, Scanner scanner) {
        this.machine = machine;
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("Welcome to Lexicon Vending Machine");
        boolean running = true;
        while (running) {
            showProducts();
            System.out.println("Balance: " + machine.getBalance() + " kr");
            System.out.println("Choose: [1] Insert coin  [2] Buy product  [3] Return change  [0] Exit");
            System.out.print("> ");
            if (!scanner.hasNextLine()) break;
            switch (scanner.nextLine().strip()) {
                case "1" -> insertCoin();
                case "2" -> buyProduct();
                case "3" -> {
                    int change = machine.returnChange();
                    System.out.println(change == 0 ? "No balance to return." : "Change returned: " + change + " kr");
                }
                case "0" -> {
                    int change = machine.returnChange();
                    if (change > 0) System.out.println("Change returned: " + change + " kr");
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid menu choice.");
            }
            System.out.println("Balance: " + machine.getBalance() + " kr");
            System.out.println();
        }
    }

    private void showProducts() {
        System.out.println("------------------------------------");
        for (Product product : machine.getProducts()) {
            System.out.printf("[%d] %-30s - %d kr  Stock: %d%n",
                product.getId(), product.getDescription(), product.getPrice(), product.getQuantity());
        }
        System.out.println("------------------------------------");
    }

    private void insertCoin() {
        System.out.print("Insert coin: ");
        Integer coin = readInt();
        if (coin == null || !machine.insertCoin(coin))
            System.out.println("Invalid coin. Only 1, 2, 5, 10, 20, 50 kr accepted.");
    }

    private void buyProduct() {
        System.out.print("Select product ID: ");
        Integer id = readInt();
        if (id == null) { System.out.println("Invalid product ID."); return; }
        try {
            Product product = machine.purchaseProduct(id);
            System.out.println("Dispensing: " + product.getDescription());
            if (machine.getLastReturnedChange() > 0)
                System.out.println("Change returned: " + machine.getLastReturnedChange() + " kr");
        } catch (PurchaseException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private Integer readInt() {
        if (!scanner.hasNextLine()) return null;
        try { return Integer.valueOf(scanner.nextLine().strip()); }
        catch (NumberFormatException exception) { return null; }
    }
}
