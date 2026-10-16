package se.lexicon;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/** Exercise 13: Collect items and build a receipt with StringBuilder. */
public class ReceiptBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder receiptRows = new StringBuilder();
        BigDecimal total = BigDecimal.ZERO;

        while (true) {
            System.out.print("Enter item name (or 'done'): ");
            String item = scanner.nextLine().trim();
            if (item.equalsIgnoreCase("done")) {
                break;
            }
            if (item.isEmpty()) {
                System.out.println("Item name cannot be empty.");
                continue;
            }

            System.out.print("Enter price: ");
            String priceText = scanner.nextLine().trim();
            BigDecimal price;
            try {
                price = new BigDecimal(priceText).setScale(2, RoundingMode.HALF_UP);
            } catch (NumberFormatException e) {
                System.out.println("Invalid price. Please try the item again.");
                continue;
            }
            if (price.signum() < 0) {
                System.out.println("Price cannot be negative.");
                continue;
            }
            receiptRows.append(String.format("%-20.20s%10s%n", item, price.toPlainString()));
            total = total.add(price);
        }

        StringBuilder receipt = new StringBuilder();
        receipt.append("==============================\n");
        receipt.append("           Receipt\n");
        receipt.append("==============================\n");
        receipt.append(receiptRows);
        receipt.append("------------------------------\n");
        receipt.append(String.format("%-20s%10s%n", "Grand Total:",
                total.setScale(2, RoundingMode.HALF_UP).toPlainString()));
        receipt.append("==============================\n");
        System.out.println();
        System.out.print(receipt);
    }
}
