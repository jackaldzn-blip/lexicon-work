package se.lexicon.exceptions.exercise07;

public class DuplicateNameException extends Exception {
    private static final long serialVersionUID = 1L;

    public DuplicateNameException(String message) {
        super(message);
    }
}
