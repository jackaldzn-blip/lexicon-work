package se.lexicon.lambdastream;

import java.util.ArrayList;
import java.util.List;

// Part 1, exercise 3 + optional exercise 6. No Streams here.
public class PersonProcessor {

    // Check everyone and return only matching people.
    public static List<Person> filterPeople(List<Person> people, PersonRule rule) {
        List<Person> result = new ArrayList<>();

        for (Person person : people) {
            if (rule.matches(person)) {
                result.add(person);
            }
        }

        return result;
    }

    // Same filtering method with the name required in optional exercise 6.
    public static List<Person> findPeople(List<Person> people, PersonRule rule) {
        return filterPeople(people, rule);
    }

    // Check everyone and perform an action for each matching person.
    public static void applyToMatching(List<Person> people, PersonRule rule, PersonAction action) {
        for (Person person : people) {
            if (rule.matches(person)) {
                action.perform(person);
            }
        }
    }
}
