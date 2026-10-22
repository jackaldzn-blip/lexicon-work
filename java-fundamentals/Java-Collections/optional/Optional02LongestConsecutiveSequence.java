import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Optional02LongestConsecutiveSequence {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(100, 4, 200, 1, 3, 2);
        Set<Integer> unique = new HashSet<>(numbers);
        int longest = 0;
        for (int first : unique) {
            // Begin only at the start of a sequence.
            if (first != Integer.MIN_VALUE && unique.contains(first - 1)) {
                continue;
            }
            int length = 1;
            int current = first;
            while (current != Integer.MAX_VALUE && unique.contains(current + 1)) {
                current++;
                length++;
            }
            longest = Math.max(longest, length);
        }
        System.out.println("Longest consecutive length: " + longest);
    }
}
