// Collection choice: HashMap<String, Integer> for fast name-to-grade lookup.
// To rank students, copy its entries into a List and sort descending by grade;
// break grade ties alphabetically so the result is predictable.
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise11StudentGrades {
    public static void main(String[] args) {
        Map<String, Integer> grades = new HashMap<>();
        grades.put("Alice", 88);
        grades.put("Bob", 73);
        grades.put("Charlie", 95);
        grades.put("Diana", 88);
        grades.put("Eve", 64);
        grades.put("Frank", 91);

        System.out.println("Charlie's grade: " + grades.get("Charlie"));
        List<Map.Entry<String, Integer>> ranking = new ArrayList<>(grades.entrySet());
        ranking.sort(Comparator
            .comparingInt((Map.Entry<String, Integer> e) -> e.getValue())
            .reversed()
            .thenComparing(Map.Entry::getKey));
        System.out.println("Ranking (highest grade first):");
        for (Map.Entry<String, Integer> student : ranking) {
            System.out.println(student.getKey() + ": " + student.getValue());
        }
    }
}
