import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Exercise06WordFrequency {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(
            "apple", "banana", "apple", "orange", "banana", "apple", "grape", "orange"
        );
        Map<String, Integer> counts = new TreeMap<>(); // Alphabetical keys.
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
