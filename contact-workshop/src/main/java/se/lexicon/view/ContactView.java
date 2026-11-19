package se.lexicon.view;

import se.lexicon.model.Contact;

import java.io.PrintStream;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/** All terminal input and output is isolated in the View layer. */
public class ContactView {
    private final Scanner scanner;
    private final PrintStream out;

    public ContactView(Scanner scanner, PrintStream out) {
        this.scanner = Objects.requireNonNull(scanner, "scanner cannot be null");
        this.out = Objects.requireNonNull(out, "out cannot be null");
    }

    public void displayMenu() {
        out.println();
        out.println("=== Contact App ===");
        out.println("1. List all contacts");
        out.println("2. Add a contact");
        out.println("3. Find contact by name");
        out.println("0. Exit");
    }

    /** Returns null on end-of-input to allow graceful termination (e.g., Ctrl+Z). */
    public String getUserInput(String prompt) {
        out.print(prompt);
        out.flush();
        return scanner.hasNextLine() ? scanner.nextLine() : null;
    }

    public void displayContacts(List<Contact> contacts) {
        if (contacts.isEmpty()) {
            displayMessage("No contacts found.");
            return;
        }
        out.println("Contacts:");
        for (Contact contact : contacts) {
            out.println("- " + contact.getName() + " | " + contact.getPhoneNumber());
        }
    }

    public void displayMessage(String message) {
        out.println(message);
    }

    public void displayError(String message) {
        out.println("Error: " + message);
    }
}
