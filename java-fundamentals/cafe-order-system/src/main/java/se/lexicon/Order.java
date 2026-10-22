package se.lexicon;

import java.util.ArrayList;
import java.util.Locale;

// Challenge 3: the order stores its data and calculates its own bill.
public class Order {
    String customer;
    boolean member;
    ArrayList<LineItem> items = new ArrayList<>();

    Order(String customer, boolean member) {
        this.customer = customer;
        this.member = member;
    }

    void addItem(String name, double price, int quantity) {
        items.add(new LineItem(name, price, quantity));
    }

    double subtotal() {
        double sum = 0;
        for (LineItem item : items) sum += item.lineTotal();
        return sum;
    }

    double discount() {
        if (member) return subtotal() * 0.15;   // Members get 15%.
        if (subtotal() > 150) return subtotal() * 0.10;
        return 0;
    }

    double vat() {
        return (subtotal() - discount()) * 0.12;
    }

    double total() {
        return subtotal() - discount() + vat();
    }

    // Build receipt as text so console AND GUI can display it.
    String receipt() {
        String text = "======= LEXICON CAFE =======\nCustomer: " + customer + "\n";
        for (LineItem item : items) {
            text += String.format(Locale.US, "%s x%d  %.2f SEK%n", item.name, item.quantity, item.lineTotal());
        }
        text += String.format(Locale.US, "Subtotal: %.2f SEK%n", subtotal());
        if (discount() > 0) text += String.format(Locale.US, "Discount: -%.2f SEK%n", discount());
        text += String.format(Locale.US, "VAT: %.2f SEK%nTOTAL: %.2f SEK%n", vat(), total());
        return text + "Thank you, " + customer + "!\n============================\n";
    }

    void printReceipt() {
        System.out.println(receipt());
    }
}
