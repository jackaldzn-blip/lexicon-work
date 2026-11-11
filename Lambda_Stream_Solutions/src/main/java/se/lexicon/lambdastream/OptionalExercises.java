package se.lexicon.lambdastream;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

// EXTRA ONLY. Read Main.java first.
public class OptionalExercises {
        public static void run(List<Person> people, PersonRule isActive,
                        PersonRule isAdult, PersonRule livesInStockholm) {
                System.out.println("=== OPTIONAL EXERCISES ===");

                // Part 1, optional 5: Combine existing rules.
                PersonRule activeAndAdult = person -> isActive.matches(person) && isAdult.matches(person);
                PersonRule adultOrStockholm = person -> isAdult.matches(person) || livesInStockholm.matches(person);
                PersonRule notActive = person -> !isActive.matches(person);

                System.out.println("Active AND adult: " + PersonProcessor.filterPeople(people, activeAndAdult));
                System.out.println("Adult OR Stockholm: " + PersonProcessor.filterPeople(people, adultOrStockholm));
                System.out.println("NOT active: " + PersonProcessor.filterPeople(people, notActive));

                // Part 1, optional 6: Use the reusable processor methods.
                System.out.println("findPeople (adults): " + PersonProcessor.findPeople(people, isAdult));
                PersonAction printName = person -> System.out.println(person.getName());
                System.out.println("Names of active adults:");
                PersonProcessor.applyToMatching(people, activeAndAdult, printName);

                // Part 1, optional 7: Java's built-in interfaces instead of our own.
                Predicate<Person> adultPredicate = person -> person.getAge() >= 18;
                Consumer<Person> emailAction = person -> System.out.println("Send email to " + person.getName());
                System.out.println("Email messages for adults using Predicate and Consumer:");
                for (Person person : people) {
                        if (adultPredicate.test(person)) {
                                emailAction.accept(person);
                        }
                }

                // Part 2, optional 6: Multiple filters.
                System.out.println("Active adults: " + people.stream()
                                .filter(person -> person.isActive())
                                .filter(person -> person.getAge() >= 18)
                                .toList());
                System.out.println("Active in Stockholm: " + people.stream()
                                .filter(person -> person.isActive())
                                .filter(person -> person.getCity().equals("Stockholm"))
                                .toList());
                System.out.println("Inactive and over 30: " + people.stream()
                                .filter(person -> !person.isActive())
                                .filter(person -> person.getAge() > 30)
                                .toList());

                // Part 2, optional 7: Unique, sorted cities and first letters.
                System.out.println("Unique sorted cities: " + people.stream()
                                .map(person -> person.getCity())
                                .distinct()
                                .sorted()
                                .toList());
                System.out.println("Unique first letters: " + people.stream()
                                .map(person -> person.getName().substring(0, 1))
                                .distinct()
                                .sorted()
                                .toList());

                // Part 2, optional 8: Formatting and emails.
                System.out.println("Formatted: " + people.stream()
                                .map(person -> person.getName() + " (" + person.getAge() + ") - " + person.getCity())
                                .toList());
                System.out.println("Emails: " + people.stream()
                                .map(person -> person.getName().toLowerCase() + "@example.com")
                                .toList());
        }
}
