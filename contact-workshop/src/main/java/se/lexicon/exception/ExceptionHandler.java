package se.lexicon.exception;

import se.lexicon.view.ContactView;

import java.util.Objects;

/** Single place to translate application exceptions into user-facing errors. */
public class ExceptionHandler {
    private final ContactView view;

    public ExceptionHandler(ContactView view) {
        this.view = Objects.requireNonNull(view, "view cannot be null");
    }

    public void handle(Exception exception) {
        if (exception instanceof DuplicateContactException) {
            view.displayError(exception.getMessage());
        } else if (exception instanceof ContactStorageException) {
            view.displayError("Contact storage problem: " + exception.getMessage());
        } else if (exception instanceof IllegalArgumentException) {
            view.displayError("Invalid input: " + exception.getMessage());
        } else {
            view.displayError("Unexpected problem: " + exception.getClass().getSimpleName());
        }
    }
}
