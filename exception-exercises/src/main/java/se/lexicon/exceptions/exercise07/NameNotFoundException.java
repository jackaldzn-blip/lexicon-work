package se.lexicon.exceptions.exercise07;

public class NameNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public NameNotFoundException(String message) {
        super(message);
    }
}
