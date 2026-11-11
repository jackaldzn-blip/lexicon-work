package se.lexicon.lambdastream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        // STARTER DATA (from the exercise sheet)
        List<Person> people = List.of(
                new Person("Amina", 22, "Stockholm", true),
                new Person("Erik", 17, "Uppsala", true),
                new Person("Noah", 34, "Stockholm", false),
                new Person("Sara", 29, "Gothenburg", true),
                new Person("Lina", 41, "Malmö", false),
                new Person("Omar", 19, "Stockholm", true));

        System.out.println("=== PART 1: LAMBDAS (NO STREAMS) ===");

        // Exercise 1: PersonRule is defined in PersonRule.java.

        // Exercise 2: Three rules written as simple lambdas.
        PersonRule isActive = person -> person.isActive();
        PersonRule isAdult = person -> person.getAge() >= 18;
        PersonRule livesInStockholm = person -> person.getCity().equals("Stockholm");

        // Exercise 3: Filter people using the rules.
        // The for-loop is in PersonProcessor.java.
        System.out.println("Active: " + PersonProcessor.filterPeople(people, isActive));
        System.out.println("Adults: " + PersonProcessor.filterPeople(people, isAdult));
        System.out.println("Stockholm: " + PersonProcessor.filterPeople(people, livesInStockholm));

        // Exercise 4: Define actions and run them.
        PersonAction printName = person -> System.out.println(person.getName());
        PersonAction sendEmail = person -> System.out.println("Send email to " + person.getName());

        System.out.println("Print all names:");
        for (Person person : people) {
            printName.perform(person);
        }
        System.out.println("Show email messages:");
        for (Person person : people) {
            sendEmail.perform(person);
        }

        System.out.println("=== PART 2: STREAM API ===");

        // Exercise 1: Keep only active people.
        List<Person> activePeople = people.stream()
                .filter(person -> person.isActive())
                .toList();
        System.out.println("1. Active: " + activePeople);

        // Exercise 2: Turn every person into their name.
        List<String> names = people.stream()
                .map(person -> person.getName())
                .toList();
        System.out.println("2. Names: " + names);

        // Exercise 3: Count people aged 18 or older.
        long adultCount = people.stream()
                .filter(person -> person.getAge() >= 18)
                .count();
        System.out.println("3. Adult count: " + adultCount);

        // Exercise 4: Sort from youngest to oldest.
        List<Person> sortedByAge = people.stream()
                .sorted(Comparator.comparingInt(person -> person.getAge()))
                .toList();
        System.out.println("4. Sorted by age: " + sortedByAge);

        // Exercise 5: Find the first active person in Stockholm.
        // Optional means there might not be any matching person.
        Optional<Person> firstInStockholm = people.stream()
                .filter(person -> person.isActive())
                .filter(person -> person.getCity().equals("Stockholm"))
                .findFirst();
        System.out.println("5. First active in Stockholm: " + firstInStockholm.orElse(null));

        // Optional tasks are in their own file so the basics stay easy to read.
        OptionalExercises.run(people, isActive, isAdult, livesInStockholm);
    }
}
