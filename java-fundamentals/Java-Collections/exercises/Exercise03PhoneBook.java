import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise03PhoneBook {
    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Alice", "070-111-1111");
        phoneBook.put("Bob", "070-222-2222");
        phoneBook.put("Charlie", "070-333-3333");
        phoneBook.put("Diana", "070-444-4444");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name: ");
        String name = scanner.nextLine().trim();
        // Map lookup by name. A case-insensitive option could be added later.
        String number = phoneBook.get(name);
        System.out.println(number != null ? number : "Contact not found.");
    }
}
