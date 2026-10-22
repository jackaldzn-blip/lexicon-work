import java.util.ArrayList;

public class Exercise01ShoppingList {
    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<>();
        items.add("Milk");
        items.add("Bread");
        items.add("Eggs");
        items.add("Apples");
        items.add("Rice");

        System.out.println("Original shopping list:");
        printNumbered(items);
        items.remove("Bread"); // Remove by name, not index.
        System.out.println("After removing Bread:");
        printNumbered(items);
    }

    private static void printNumbered(ArrayList<String> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
    }
}
