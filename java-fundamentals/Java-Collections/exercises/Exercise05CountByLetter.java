import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercise05CountByLetter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Anna", "Bob", "Alice", "Charlie", "Amanda", "David", "Amy", "Brian");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a letter: ");
        String input = scanner.nextLine().trim();
        if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            System.out.println("Please enter exactly one letter.");
            return;
        }

        char firstLetter = Character.toLowerCase(input.charAt(0));
        int count = 0;
        for (String name : names) {
            if (Character.toLowerCase(name.charAt(0)) == firstLetter) {
                count++;
            }
        }
        System.out.println("Names beginning with '" + input + "': " + count);
    }
}
