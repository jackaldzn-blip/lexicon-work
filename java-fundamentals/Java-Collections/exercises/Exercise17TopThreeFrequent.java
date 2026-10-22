import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise17TopThreeFrequent {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(
            "java", "python", "java", "c++", "python", "java",
            "ruby", "c++", "python", "ruby", "java"
        );
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        List<Map.Entry<String, Integer>> ranking = new ArrayList<>(counts.entrySet());
        ranking.sort(Comparator
            .comparingInt((Map.Entry<String, Integer> e) -> e.getValue())
            .reversed()
            .thenComparing(Map.Entry::getKey)); // Alphabetical tiebreaker.
        for (int i = 0; i < Math.min(3, ranking.size()); i++) {
            Map.Entry<String, Integer> entry = ranking.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
