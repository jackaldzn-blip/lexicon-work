package se.lexicon.lambdastream;

// Part 1, exercise 1: a rule that answers true or false.
@FunctionalInterface
public interface PersonRule {
    boolean matches(Person person);
}
