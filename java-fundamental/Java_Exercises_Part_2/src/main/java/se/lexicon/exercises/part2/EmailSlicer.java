package se.lexicon.exercises.part2;

import java.util.Scanner;

/** Exercise 2: Extract an email's username and domain. */
public class EmailSlicer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter email: ");
        String email = scanner.nextLine().trim();

        int atPosition = email.indexOf('@');
        if (atPosition <= 0 || atPosition == email.length() - 1
                || email.indexOf('@', atPosition + 1) != -1) {
            System.out.println("Please enter a valid email address.");
            return;
        }

        String username = email.substring(0, atPosition);
        String domain = email.substring(atPosition + 1);
        System.out.println("Username: " + username);
        System.out.println("Domain  : " + domain);
    }
}
