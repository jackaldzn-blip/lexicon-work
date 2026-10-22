import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Exercise07RemoveDuplicatesKeepOrder {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 7, 2, 7, 9, 4, 1, 9, 3);
        Set<Integer> seen = new LinkedHashSet<>(numbers);
        List<Integer> withoutDuplicates = new ArrayList<>(seen);
        System.out.println(withoutDuplicates); // [4, 7, 2, 9, 1, 3]
    }
}
