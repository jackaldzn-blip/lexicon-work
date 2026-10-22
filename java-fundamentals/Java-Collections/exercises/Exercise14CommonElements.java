import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Exercise14CommonElements {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> b = Arrays.asList(3, 6, 9, 12, 15);
        Set<Integer> common = new LinkedHashSet<>(a);
        common.retainAll(new HashSet<>(b)); // Fast membership tests against B.
        System.out.println("Common elements: " + common);
    }
}
