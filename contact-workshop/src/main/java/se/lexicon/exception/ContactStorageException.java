package se.lexicon.exception;

/** Checked exception for reading, writing, or parsing persisted contacts. */
public class ContactStorageException extends Exception {
    public ContactStorageException(String message) {
        super(message);
    }

    public ContactStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
