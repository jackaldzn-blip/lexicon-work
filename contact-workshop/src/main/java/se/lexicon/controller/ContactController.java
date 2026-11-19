package se.lexicon.controller;

import se.lexicon.data.ContactDAO;
import se.lexicon.exception.ExceptionHandler;
import se.lexicon.exception.ContactStorageException;
import se.lexicon.exception.DuplicateContactException;
import se.lexicon.model.Contact;
import se.lexicon.view.ContactView;

import java.util.List;
import java.util.Objects;

/** Handles application flow; all errors go through the centralized handler. */
public class ContactController {
    private final ContactDAO contactDAO;
    private final ContactView contactView;
    private final ExceptionHandler exceptionHandler;

    public ContactController(ContactDAO contactDAO, ContactView contactView) {
        this.contactDAO = Objects.requireNonNull(contactDAO, "contactDAO cannot be null");
        this.contactView = Objects.requireNonNull(contactView, "contactView cannot be null");
        this.exceptionHandler = new ExceptionHandler(contactView);
    }

    public void run() {
        contactView.displayMessage("Welcome to the Contact App!");
        boolean running = true;
        while (running) {
            contactView.displayMenu();
            String choice = contactView.getUserInput("Choose an option: ");
            if (choice == null) {
                break;
            }
            try {
                switch (choice.trim()) {
                    case "1":
                        contactView.displayContacts(contactDAO.findAll());
                        break;
                    case "2":
                        running = addContact();
                        break;
                    case "3":
                        running = searchContact();
                        break;
                    case "0":
                        running = false;
                        break;
                    default:
                        contactView.displayError("Unknown option. Please choose 0, 1, 2, or 3.");
                }
            } catch (Exception exception) {
                exceptionHandler.handle(exception);
            }
        }
        contactView.displayMessage("Goodbye!");
    }

    private boolean addContact() throws ContactStorageException, DuplicateContactException {
        String name = contactView.getUserInput("Name: ");
        if (name == null) return false;
        String phoneNumber = contactView.getUserInput("Phone number (10 digits): ");
        if (phoneNumber == null) return false;
        contactDAO.save(new Contact(name, phoneNumber));
        contactView.displayMessage("Contact saved successfully.");
        return true;
    }

    private boolean searchContact() throws ContactStorageException {
        String name = contactView.getUserInput("Name to search: ");
        if (name == null) return false;
        Contact result = contactDAO.findByName(name);
        if (result == null) {
            contactView.displayMessage("No contact found with that name.");
        } else {
            contactView.displayContacts(List.of(result));
        }
        return true;
    }
}
