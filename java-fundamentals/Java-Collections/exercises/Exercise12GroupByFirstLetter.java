import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Exercise12GroupByFirstLetter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
            "Alice", "Bob", "Anna", "Charlie", "Brian", "Amanda", "Carl"
        );
        Map<Character, List<String>> groups = new TreeMap<>();
        for (String name : names) {
            char initial = Character.toUpperCase(name.charAt(0));
            groups.computeIfAbsent(initial, key -> new ArrayList<>()).add(name);
        }
        for (Map.Entry<Character, List<String>> entry : groups.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
