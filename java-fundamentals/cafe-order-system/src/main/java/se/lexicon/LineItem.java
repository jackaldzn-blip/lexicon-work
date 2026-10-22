package se.lexicon;

// Challenge 4: one product in a customer's order.
public class LineItem {
    String name;
    double price;
    int quantity;

    LineItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    double lineTotal() {
        return price * quantity;
    }
}
