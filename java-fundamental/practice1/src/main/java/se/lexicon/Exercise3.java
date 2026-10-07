package se.lexicon;

public class Exercise3 {
    public static void main(String[] args) {
        String item1 = "Apple";
        int quantity1 = 2;
        double price1 = 15.00;

        String item2 = "Milk";
        int quantity2 = 1;
        double price2 = 22.50;

        String item3 = "Bread";
        int quantity3 = 3;
        double price3 = 18.00;

        double total1 = quantity1 * price1;
        double total2 = quantity2 * price2;
        double total3 = quantity3 * price3;
        double grandTotal = total1 + total2 + total3;

        System.out.println("==============================");
        System.out.println("           Receipt");
        System.out.println("==============================");
        System.out.printf("%-12s %d x %.2f = %.2f SEK%n", item1, quantity1, price1, total1);
        System.out.printf("%-12s %d x %.2f = %.2f SEK%n", item2, quantity2, price2, total2);
        System.out.printf("%-12s %d x %.2f = %.2f SEK%n", item3, quantity3, price3, total3);
        System.out.println("------------------------------");
        System.out.printf("Grand Total:           %.2f SEK%n", grandTotal);
        System.out.println("==============================");
    }
}
