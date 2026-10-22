package se.lexicon;

import java.util.Scanner;

public class Exercise17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        boolean longEnough = password.length() >= 8;
        boolean hasUppercase = false;
        boolean hasDigit = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                hasUppercase = true;
            }

            if (ch >= '0' && ch <= '9') {
                hasDigit = true;
            }
        }

        int rulesMet = 0;

        if (longEnough) {
            rulesMet++;
        }
        if (hasUppercase) {
            rulesMet++;
        }
        if (hasDigit) {
            rulesMet++;
        }

        String rating;

        if (rulesMet == 3) {
            rating = "Strong";
        } else if (rulesMet == 2) {
            rating = "Medium";
        } else {
            rating = "Weak";
        }

        System.out.println("Rules met: " + rulesMet + "/3");
        System.out.println("Rating: " + rating);

        scanner.close();
    }
}
