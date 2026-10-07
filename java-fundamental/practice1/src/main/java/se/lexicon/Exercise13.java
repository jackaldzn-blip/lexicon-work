package se.lexicon;

import java.util.Scanner;

public class Exercise13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter day: ");
        String day = scanner.nextLine();

        String result = switch (day.toLowerCase()) {
            case "monday", "tuesday", "wednesday", "thursday", "friday" -> "Weekday";
            case "saturday", "sunday" -> "Weekend";
            default -> "Unknown day";
        };

        System.out.println(result);

        scanner.close();
    }
}
