package se.lexicon.lambdastream;

// Part 1, exercise 4: an action that does something with a person.
@FunctionalInterface
public interface PersonAction {
    void perform(Person person);
}
