import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise13MostFrequentWord {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(
            "cat", "dog", "cat", "bird", "dog", "cat", "fish", "dog", "dog"
        );
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        String mostFrequent = null;
        int highestCount = 0;
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > highestCount ||
                    (entry.getValue() == highestCount &&
                     (mostFrequent == null || entry.getKey().compareTo(mostFrequent) < 0))) {
                mostFrequent = entry.getKey();
                highestCount = entry.getValue();
            }
        }
        System.out.println(mostFrequent + ": " + highestCount);
    }
}
