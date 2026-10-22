// Collection choice: HashSet<String>.
// A HashSet stores each student only once, checks duplicates efficiently,
// and does not guarantee an order (which this task does not require).
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exercise09SubmissionTracker {
    public static void main(String[] args) {
        Set<String> submitted = new HashSet<>();
        for (String student : Arrays.asList(
                "Alice", "Bob", "Charlie", "Diana", "Alice",
                "Eve", "Frank", "Bob", "Grace", "Hugo")) {
            if (!submitted.add(student)) { // add() returns false for duplicates.
                System.out.println("Rejected duplicate submission: " + student);
            }
        }
        System.out.println("Submitted students: " + submitted);
    }
}
