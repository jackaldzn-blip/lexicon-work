package se.lexicon.exception;

/** Checked exception when a new contact has an existing name (ignoring case). */
public class DuplicateContactException extends Exception {
    public DuplicateContactException(String message) {
        super(message);
    }
}
